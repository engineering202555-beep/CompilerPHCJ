

import ASTHCJ.*;
import VisitorHCJ.*;
import htmlCSS.*;

import python.ASTpy.PYProgramNode;
import python.FlaskLexer;
import python.FlaskParser;
import python.SemanticPY.PythonSemanticAnalyzer;
import python.VisitorPY.FlaskContextExtractor;
import python.VisitorPY.FlaskVisitor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * نقطة التشغيل الموحّدة الوحيدة للمشروع.
 *
 * تدمج ما كان موزعًا سابقًا بين:
 * GenerationRunner / Main / SemanticReportRunner
 *
 * في تشغيلة واحدة تُنتج:
 * output/
 * compiler_output/
 *
 * بشكل متسق.
 */
public class CompilerRunner {

    private static final StringBuilder log = new StringBuilder();

    /*
     * ============================================================
     * مسارات المشروع
     * ============================================================
     *
     * PROJECT_ROOT هو مجلد التشغيل الحالي للمشروع.
     *
     * حسب إعداد مشروعك الحالي:
     *
     * CompilerPythonHtmlCSSJinja-main
     * └── CompilerPythonHtmlCSSJinja-main
     *     └── src
     *
     * لذلك نصل إلى src الحقيقي من خلال:
     *
     * PROJECT_ROOT
     *      ↓
     * CompilerPythonHtmlCSSJinja-main
     *      ↓
     * src
     */

    private static final Path PROJECT_ROOT =
            Paths.get("").toAbsolutePath().normalize();

    private static final Path SOURCE_ROOT =
            PROJECT_ROOT

                    .resolve("src");

    private static final Path TESTS_DIR =
            SOURCE_ROOT.resolve("Tests");

    private static final Path TEMPLATES_DIR =
            SOURCE_ROOT.resolve("TestHtmlCJ");

    private static final Path OUTPUT_DIR =
            PROJECT_ROOT.resolve("output");

    private static final Path COMPILER_OUTPUT_DIR =
            PROJECT_ROOT.resolve("compiler_output");


    // خريطة: اسم القالب المصدر -> الاسم النهائي المطلوب في output/
    private static final Map<String, String> OUTPUT_NAME_MAP = Map.of(
            "products_template.html", "index.html",
            "add_product_template.html", "add_product.html",
            "details_template.html", "details_product.html"
    );


    public static void main(String[] args) throws Exception {

        /*
         * ------------------------------------------------------------
         * تجهيز مسارات output و compiler_output
         * ------------------------------------------------------------
         */
        log.setLength(0);

            System.out.println(" دخلنا CompilerRunner.main()");



            // ============================================================
            // إنشاء output و compiler_output
            // ============================================================

            System.out.println(" قبل إنشاء المجلدات");

            Files.createDirectories(OUTPUT_DIR);

            System.out.println(" output جاهز");

            Files.createDirectories(COMPILER_OUTPUT_DIR);

            System.out.println(" compiler_output جاهز");




            logLine("Generation started at: " + LocalDateTime.now());

            // باقي الكود كما هو...

        String outputDir =
                OUTPUT_DIR.toString() + java.io.File.separator;

        String compilerOutputDir =
                COMPILER_OUTPUT_DIR.toString() + java.io.File.separator;

        Files.createDirectories(OUTPUT_DIR);
        Files.createDirectories(COMPILER_OUTPUT_DIR);

        logLine("Generation started at: " + LocalDateTime.now());

        SemanticReportWriter reportWriter =
                new SemanticReportWriter();

        boolean semanticErrorFound = false;
        // ============================================================
        // Python: AST + Context + Semantic
        // ============================================================

        String pythonFilePath =
                TESTS_DIR.resolve("test1.txt").toString();

        PYProgramNode pythonAst =
                buildPythonAstFromFile(pythonFilePath);


        // ------------------------------------------------------------
        // (1) تحليل دلالي لبايثون
        // ------------------------------------------------------------

        PythonSemanticAnalyzer pyAnalyzer =
                new PythonSemanticAnalyzer();

        pyAnalyzer.analyze(pythonAst);
        reportWriter.addPythonFileSection(
                pythonFilePath,
                pyAnalyzer.getErrors()
        );


        // ------------------------------------------------------------
        // (2) تصدير AST بايثون كـ JSON حقيقي
        // ------------------------------------------------------------

        String pythonTreeText =
                capturePrintedTree(
                        () -> pythonAst.printDetailed("", true)
                );

        writeAstJson(
                compilerOutputDir + "ast_python.json",
                "PythonAST",
                pythonFilePath,
                pythonTreeText
        );


        // ============================================================
        // بوابة الحماية:
        // أخطاء بايثون توقف كل التوليد
        // ============================================================

        if (pyAnalyzer.getErrorCount() > 0) {

            logLine(
                    "PYTHON SEMANTIC ERRORS FOUND ("
                            + pyAnalyzer.getErrorCount()
                            + ") -> GENERATION ABORTED"
            );

            for (Object err : pyAnalyzer.getErrors()) {
                logLine("   " + err);
            }

            reportWriter.writeToFile(
                    compilerOutputDir + "semantic_report.txt"
            );

            logLine(
                    "Generation finished at: "
                            + LocalDateTime.now()
                            + " (no HTML output produced)"
            );

            Files.writeString(
                    Paths.get(
                            compilerOutputDir + "generation_log.txt"
                    ),
                    log.toString()
            );

            System.out.println(
                    "توجد أخطاء دلالية في ملف بايثون — تم إيقاف التوليد بالكامل. "
                            + "راجع compiler_output/semantic_report.txt"
            );

            return;
        }


        // ============================================================
        // (3) استخراج بيانات السياق لتغذية توليد Jinja
        // ============================================================

        FlaskContextExtractor extractor =
                new FlaskContextExtractor();

        extractor.extract(pythonAst);

        List<String> liveFlaskVariables =
                extractor.getExtractedVariables();

        List<String> flaskFunctionsList =
                extractor.getExtractedFunctions();

        Map<String, Object> contextData =
                extractor.getExtractedContextData();

        Map<String, String> routes =
                extractor.getExtractedRoutes();


        logLine("Python source: " + pythonFilePath);
        logLine("Extracted routes: " + routes);
        logLine("Extracted context keys: " + contextData.keySet());
        logLine("");


        // ============================================================
        // HTML / CSS / Jinja
        // ============================================================

        String[] templates = {
                "products_template.html",
                "add_product_template.html",
                "details_template.html"
        };


        StringBuilder combinedJinjaTree =
                new StringBuilder();


        for (String templateName : templates) {

            String finalName =
                    OUTPUT_NAME_MAP.getOrDefault(
                            templateName,
                            templateName
                    );

            String treeText =
                    generateTemplate(
                            templateName,
                            finalName,
                            contextData,
                            routes,
                            liveFlaskVariables,
                            flaskFunctionsList,
                            outputDir,
                            reportWriter
                    );
            combinedJinjaTree
                    .append("=== ")
                    .append(templateName)
                    .append(" -> ")
                    .append(finalName)
                    .append(" ===\n")
                    .append(treeText)
                    .append("\n");
        }


        // ------------------------------------------------------------
        // تصدير AST جينجا / HTML المجمّع
        // ------------------------------------------------------------

        writeAstJson(
                compilerOutputDir + "ast_jinja.json",
                "JinjaHtmlAST",
                String.join(",", templates),
                combinedJinjaTree.toString()
        );


        // ============================================================
        // الملفات الداعمة
        // ============================================================

        /*
         * app.py:
         *
         * أولاً يبحث في جذر المشروع.
         * وإذا لم يجده يستخدم test1.txt كـ fallback.
         */

        copyStaticFileWithFallback(
                "app.py",
                TESTS_DIR.resolve("test1.txt").toString(),
                outputDir + "app.py"
        );


        /*
         * Style.css:
         *
         * موجود داخل:
         *
         * src/TestHtmlCJ/Style.css
         */

        copyStaticFileIfExists(
                TEMPLATES_DIR.resolve("Style.css").toString(),
                outputDir + "Style.css"
        );


        /*
         * script.js:
         *
         * يبحث عنه في جذر المشروع.
         */

        copyStaticFileIfExists(
                "script.js",
                outputDir + "script.js"
        );


        // ============================================================
        // كتابة الملفات النهائية
        // ============================================================

        reportWriter.writeToFile(
                compilerOutputDir + "semantic_report.txt"
        );

        logLine(
                "Generation finished at: "
                        + LocalDateTime.now()
        );

        Files.writeString(
                Paths.get(
                        compilerOutputDir + "generation_log.txt"
                ),
                log.toString()
        );


        System.out.println(
                "تم إنشاء output/ و compiler_output/ بنجاح في تشغيلة واحدة."
        );
    }


    // ================================================================
    // Generate Template
    // ================================================================

    private static String generateTemplate(
            String templateName,
            String finalOutputName,
            Map<String, Object> contextData,
            Map<String, String> routes,
            List<String> flaskVariables,
            List<String> flaskFunctions,
            String outputDir,
            SemanticReportWriter reportWriter
    ) throws Exception {


        /*
         * مسار قالب Jinja / HTML
         *
         * بدل المسار المطلق:
         *
         * C:/Project2CleanAndFixed/...
         *
         * نستخدم TEMPLATES_DIR.
         */

        String inputPath =
                TEMPLATES_DIR
                        .resolve(templateName)
                        .toString();


        String outputPath =
                outputDir + finalOutputName;


        // ------------------------------------------------------------
        // بناء HTML AST
        // ------------------------------------------------------------

        HtmlDocument htmlAst =
                buildHtmlAstFromFile(inputPath);


        // ------------------------------------------------------------
        // Semantic Analysis
        // ------------------------------------------------------------

        SemanticAnalyzerVisitor semanticAnalyzer =
                new SemanticAnalyzerVisitor(
                        flaskVariables,
                        flaskFunctions
                );

        htmlAst.accept(semanticAnalyzer);

        reportWriter.addHtmlFileSection(
                templateName,
                semanticAnalyzer.getErrors()
        );


        // ------------------------------------------------------------
        // نص الشجرة
        // ------------------------------------------------------------

        String treeText =
                capturePrintedTree(
                        () -> new VisitorHJC()
                                .visitHtmlDocument(htmlAst)
                );


        // ------------------------------------------------------------
        // إذا كان هناك خطأ دلالي
        // ------------------------------------------------------------

        if (semanticAnalyzer.getErrorCount() > 0) {

            logLine(
                    "TEMPLATE: "
                            + templateName
                            + " -> ABORTED (semantic errors: "
                            + semanticAnalyzer.getErrorCount()
                            + ")"
            );

            for (String err :
                    semanticAnalyzer.getErrors()) {

                logLine("   " + err);
            }
            try {
                Files.deleteIfExists(Path.of(outputPath));

                logLine(
                        "stale output removed: "
                                + outputPath
                );

            } catch (IOException e) {

                logLine(
                        "warning: could not remove stale output: "
                                + outputPath
                );
            }
            return treeText;
        }


        // ------------------------------------------------------------
        // Code Generation
        // ------------------------------------------------------------

        CodeGeneratorVisitor generator =
                new CodeGeneratorVisitor();


        generator.setContext(contextData);
        generator.setRoutes(routes);


        generator.generateOutput(
                htmlAst,
                outputPath,
                flaskVariables,
                flaskFunctions
        );


        // ------------------------------------------------------------
        // التأكد من عدم بقاء Jinja في HTML النهائي
        // ------------------------------------------------------------

        String generatedContent =
                Files.readString(
                        Path.of(outputPath)
                );


        boolean stillHasJinja =
                generatedContent.contains("{{")
                        || generatedContent.contains("{%");


        logLine("TEMPLATE: " + templateName);
        logLine("  input:  " + inputPath);
        logLine("  output: " + outputPath);
        logLine("  semantic errors: 0");
        logLine(
                "  remaining Jinja syntax ({{ or {%) in output: "
                        + stillHasJinja
        );
        logLine("");


        return treeText;
    }


    // ================================================================
    // Build Python AST
    // ================================================================

    private static PYProgramNode buildPythonAstFromFile(
            String filePath
    ) throws Exception {

        String source =
                Files.readString(
                        Path.of(filePath)
                );


        CharStream input =
                CharStreams.fromString(source);


        FlaskLexer lexer =
                new FlaskLexer(input);


        CommonTokenStream tokens =
                new CommonTokenStream(lexer);


        FlaskParser parser =
                new FlaskParser(tokens);


        ParseTree parseTree =
                parser.program();


        FlaskVisitor pythonAstBuilder =
                new FlaskVisitor();


        return (PYProgramNode)
                pythonAstBuilder.visit(parseTree);
    }


    // ================================================================
    // Build HTML AST
    // ================================================================

    private static HtmlDocument buildHtmlAstFromFile(
            String filePath
    ) throws Exception {

        String source =
                Files.readString(
                        Path.of(filePath)
                );


        CharStream input =
                CharStreams.fromString(source);


        HtmlLexer lexer =
                new HtmlLexer(input);


        CommonTokenStream tokens =
                new CommonTokenStream(lexer);
        HtmlParser parser =
                new HtmlParser(tokens);


        ParseTree parseTree =
                parser.htmlDocument();


        AstBuilderVisitor astBuilder =
                new AstBuilderVisitor();


        return (HtmlDocument)
                astBuilder.visit(parseTree);
    }


    // ================================================================
    // Capture Printed Tree
    // ================================================================

    private static String capturePrintedTree(
            Runnable printAction
    ) {

        PrintStream original =
                System.out;


        ByteArrayOutputStream buffer =
                new ByteArrayOutputStream();


        System.setOut(
                new PrintStream(buffer)
        );


        try {

            printAction.run();

        } finally {

            System.setOut(original);
        }


        return buffer.toString();
    }


    // ================================================================
    // Write AST JSON
    // ================================================================

    private static void writeAstJson(
            String path,
            String treeKind,
            String sourceFiles,
            String treeText
    ) throws IOException {


        String json =
                "{\n"
                        + "  \"tree\": \""
                        + escapeJsonLine(treeKind)
                        + "\",\n"

                        + "  \"source\": \""
                        + escapeJsonLine(sourceFiles)
                        + "\",\n"

                        + "  \"generatedAt\": \""
                        + LocalDateTime.now()
                        + "\",\n"

                        + "  \"astText\": "
                        + formatAsJsonArray(treeText)
                        + "\n"

                        + "}\n";


        Files.writeString(
                Paths.get(path),
                json
        );
    }


    // ================================================================
    // Format JSON Array
    // ================================================================

    private static String formatAsJsonArray(
            String text
    ) {

        if (text == null || text.isEmpty()) {
            return "[]";
        }


        String[] lines =
                text.split("\\r?\\n");


        StringBuilder sb =
                new StringBuilder("[\n");


        for (int i = 0;
             i < lines.length;
             i++) {

            sb.append("    \"")
                    .append(
                            escapeJsonLine(lines[i])
                    )
                    .append("\"");


            if (i < lines.length - 1) {
                sb.append(",");
            }


            sb.append("\n");
        }


        sb.append("  ]");


        return sb.toString();
    }


    // ================================================================
    // Escape JSON
    // ================================================================

    private static String escapeJsonLine(
            String s
    ) {

        return s
                .replace("\\", "\\\\")
                .replace("\"", "\\\"");
    }


    // ================================================================
    // Copy Static File
    // ================================================================

    private static void copyStaticFileIfExists(
            String sourcePath,
            String destPath
    ) {

        try {

            Path src =
                    Paths.get(sourcePath);


            if (Files.exists(src)) {

                Files.copy(
                        src,
                        Paths.get(destPath),
                        StandardCopyOption.REPLACE_EXISTING
                );


                logLine(
                        "Copied supporting file: "
                                + sourcePath
                                + " -> "
                                + destPath
                );

            } else {
                logLine(
                        "Supporting file not found "
                                + "(skipped, not generated): "
                                + sourcePath
                );
            }

        } catch (IOException e) {

            logLine(
                    "Could not copy supporting file "
                            + sourcePath
                            + ": "
                            + e.getMessage()
            );
        }
    }


    // ================================================================
    // Copy Static File With Fallback
    // ================================================================

    private static void copyStaticFileWithFallback(
            String primarySource,
            String fallbackSource,
            String destPath
    ) {

        try {

            // --------------------------------------------------------
            // المصدر الأساسي
            // --------------------------------------------------------

            Path primary =
                    Paths.get(primarySource);


            if (Files.exists(primary)) {

                Files.copy(
                        primary,
                        Paths.get(destPath),
                        StandardCopyOption.REPLACE_EXISTING
                );


                logLine(
                        "Copied supporting file: "
                                + primarySource
                                + " -> "
                                + destPath
                );


                return;
            }


            // --------------------------------------------------------
            // المصدر البديل
            // --------------------------------------------------------

            Path fallback =
                    Paths.get(fallbackSource);


            if (Files.exists(fallback)) {

                Files.copy(
                        fallback,
                        Paths.get(destPath),
                        StandardCopyOption.REPLACE_EXISTING
                );


                logLine(
                        "Primary "
                                + primarySource
                                + " not found; copied fallback "
                                + fallbackSource
                                + " -> "
                                + destPath
                );


                return;
            }


            logLine(
                    "Supporting file not found "
                            + "(skipped, not generated): "
                            + primarySource
            );


        } catch (IOException e) {

            logLine(
                    "Could not copy supporting file "
                            + primarySource
                            + ": "
                            + e.getMessage()
            );
        }
    }


    // ================================================================
    // Log
    // ================================================================

    private static void logLine(
            String text
    ) {

        log.append(text)
                .append("\n");
    }
}


