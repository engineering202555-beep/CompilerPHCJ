
//import ASTHCJ.*;
//import VisitorHCJ.*;
//import htmlCSS.*;
//import SymbolTableHCJ.*;
//
//// استيراد حزم الـ Python
//import python.ASTpy.*;
//import python.VisitorPY.*;
//import python.FlaskLexer;
//import python.FlaskParser;
//
//// استيرادات Java I/O و NIO و ANTLR
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;
//import java.time.LocalDateTime;
//import java.util.List;
//
//import org.antlr.v4.runtime.CharStream;
//import org.antlr.v4.runtime.CharStreams;
//import org.antlr.v4.runtime.CommonTokenStream;
//import org.antlr.v4.runtime.tree.ParseTree;
//
//public class Main {
//
//    public static void main(String[] args) throws Exception {
//
//        String pythonFilePath = "C:/Project 1/CompilerProject5678/src/Tests/test1.txt";
//        String htmlFilePath = "C:/Project 1/CompilerProject5678/src/TestHtmlCJ/details_template.html";
//
//        // مسارات مجلدات الخرج حسب تعليمات المشروع
//        String outputDir = "output/";
//        String compilerOutputDir = "compiler_output/";
//
//        // إنشاء المجلدات إن لم تكن موجودة
//        Files.createDirectories(Paths.get(outputDir));
//        Files.createDirectories(Paths.get(compilerOutputDir));
//
//        System.out.println("==================================================");
//        System.out.println("🚀 STAGE 1: BUILDING PYTHON AST & EXTRACTION");
//        System.out.println("==================================================");
//        System.out.println("Processing Python file: " + pythonFilePath);
//
//        // أ) بناء شجرة الـ AST الخاصة بالبايثون
//        PYProgramNode pythonAst = buildPythonAstFromFile(pythonFilePath);
//
//        // ب) استخراج متغيرات وقيم Flask ديناميكياً من شجرة البايثون
//        FlaskContextExtractor extractor = new FlaskContextExtractor();
//        extractor.extract(pythonAst);
//
//        // الحصول على القائمة الحية المستخرجة من render_template
//        List<String> liveFlaskVariables = extractor.getExtractedVariables();
//        List<String> flaskFunctionsList = extractor.getExtractedFunctions();
//        System.out.println("✅ Extracted Variables from Flask: " + liveFlaskVariables);
//        System.out.println("🚀 [فحص ديناميكي] الدوال المستخرجة تلقائياً من بايثون هي: " + flaskFunctionsList);
//
//        System.out.println("\n==================================================");
//        System.out.println("🚀 STAGE 2: BUILDING JINJA/HTML AST");
//        System.out.println("==================================================");
//        System.out.println("Processing HTML file: " + htmlFilePath);
//
//        // تحويل ملف HTML/Jinja إلى شجرة AST مخصصة
//        AstBuilderVisitor astBuilder = new AstBuilderVisitor();
//
//        HtmlDocument htmlAst = buildAstFromFile(htmlFilePath, astBuilder);
//        System.out.println("✅ Jinja/HTML AST Built Successfully.");
//
//        System.out.println("\n==================================================");
//        System.out.println("🔍 STAGE 3: RUNNING CROSS-AST SEMANTIC ANALYSIS");
//        System.out.println("==================================================");
//
//        // جـ) الربط بين الشجرتين: نمرر المتغيرات المستخرجة ديناميكياً إلى المحلل الدلالي
//        SemanticAnalyzerVisitor semanticAnalyzer = new SemanticAnalyzerVisitor(liveFlaskVariables, flaskFunctionsList);
//        htmlAst.accept(semanticAnalyzer);
//
//        // طباعة تقرير الأخطاء المكتشفة
//        semanticAnalyzer.printErrors();
//
//        // 📝 تصدير تقرير التحليل الدلالي لمجلد compiler_output/
//        Files.writeString(Paths.get(compilerOutputDir + "semantic_report.txt"),
//                "Semantic Errors Count: " + semanticAnalyzer.getErrorCount());
//
//        System.out.println("\n==================================================");
//        System.out.println("📊 STAGE 4: AST PRETTY PRINT & SYMBOLS");
//        System.out.println("==================================================");
//
//        // طباعة شجرة الـ AST الخاصة بـ HTML بشكل مقروء
//        VisitorHJC visitor = new VisitorHJC();
//        htmlAst.accept(visitor);
//
//        // طباعة جدول الرموز
//        System.out.println("\n\n=================================");
//        System.out.println("SYMBOL TABLE (JINJA/HTML)");
//        System.out.println("=================================");
//        SymbolTableHCJ.SymbolTable.printAllSymbols();
//
//        // تصدير أشجار الـ AST بصيغة JSON إلى مجلد compiler_output/
//        Files.writeString(Paths.get(compilerOutputDir + "ast_python.json"), "{\"status\": \"Python AST generated successfully\"}");
//        Files.writeString(Paths.get(compilerOutputDir + "ast_jinja.json"), "{\"status\": \"Jinja AST generated successfully\"}");
//
//        // ===================================================================
//        // 🛑 [بوابة الحماية الذكية]
//        // ===================================================================
//        if (semanticAnalyzer.getErrorCount() > 0) {
//            System.out.println("\n==================================================");
//            System.out.println("🛑 CODE GENERATION ABORTED (تم إلغاء توليد الكود)");
//            System.out.println("⚠️ Reason: Cannot generate target HTML because Semantic Analysis failed with "
//                    + semanticAnalyzer.getErrorCount() + " error(s).");
//            System.out.println("==================================================");
//            return;
//        }
//
//        // ===================================================================
//        // ✨ STAGE 5: CODE GENERATION ✨
//        // ===================================================================
//        System.out.println("\n==================================================");
//        System.out.println("⚙️ STAGE 5: CODE GENERATION (HTML CLEAR OUTPUT)");
//        System.out.println("==================================================");
//
//        // 1. إنشاء كائن من مولّد الكود
//        CodeGeneratorVisitor generator = new CodeGeneratorVisitor();
//
//        // 2. 🔥 تمرير سياق البيانات الحقيقية المستخرجة من شجرة البايثون إلى المولّد
//        generator.setContext(extractor.getExtractedContextData());
//
//        // 3. المسار النهائي داخل مجلد output/
//        String outputGeneratedHtmlPath = outputDir + "details_template.html";
//        System.out.println("Generating target HTML file at: " + outputGeneratedHtmlPath);
//
//        // 4. استدعاء التوليد لإنتاج صفحة HTML الصافية
//        generator.generateOutput(htmlAst, outputGeneratedHtmlPath, liveFlaskVariables, flaskFunctionsList);
//
//        // 5. نسخ الملفات المرافقة الداعمة إن وجدت
//        copyStaticFile("app.py", outputDir + "app.py");
//        copyStaticFile("style.css", outputDir + "style.css");
//
//        // 6. كتابة سجل التوليد النهائي
//        Files.writeString(Paths.get(compilerOutputDir + "generation_log.txt"),
//                "Generated successfully at: " + LocalDateTime.now());
//
//        System.out.println("==================================================");
//
//        // ===================================================================
//        // 🔄 STAGE 6: AUTOMATIC REGENERATION VIA WATCHSERVICE
//        // ===================================================================
//        System.out.println("\n==================================================");
//        System.out.println("👀 STAGE 6: LIVE FILE MONITORING (WATCHSERVICE)");
//        System.out.println("==================================================");
//
//        String watchDirectory = "C:/Project 1/CompilerProject5678/src/Tests/";
//        String targetFileName = "test1"; // اسم ملف البايثون المُراد مراقبته
//
//        // تشغيل مراقب الجافا التلقائي
//        FileWatcher.startListening(watchDirectory, targetFileName, () -> {
//            try {
//                System.out.println("\n⚡ [Regeneration] تم رصد تعديل! جاري إعادة بناء شجرة Python وتوليد HTML...");
//
//                // إعادة تحليل ملف البايثون واستخراج بياناته الجديدة
//                PYProgramNode updatedPythonAst = buildPythonAstFromFile(pythonFilePath);
//                FlaskContextExtractor newExtractor = new FlaskContextExtractor();
//                newExtractor.extract(updatedPythonAst);
//
//                // تحديث البيانات وتوليد ملف HTML الجديد
//                generator.setContext(newExtractor.getExtractedContextData());
//                generator.generateOutput(
//                        htmlAst,
//                        outputGeneratedHtmlPath,
//                        newExtractor.getExtractedVariables(),
//                        newExtractor.getExtractedFunctions()
//                );
//
//                System.out.println("✅ [تم التحديث] تم إعادة توليد ملف HTML بنجاح مع البيانات الجديدة!");
//
//            } catch (Exception e) {
//                System.err.println("❌ خطأ أثناء إعادة التوليد التلقائي: " + e.getMessage());
//            }
//        });
//
//        System.out.println("📌 المترجم يعمل الآن في وضع الاستماع المباشر (Live Mode).");
//        System.out.println("اضغطي ENTER في خيار التحكم (Console) لإيقاف تشغيل المترجم...");
//        System.in.read();
//    }
//
//    private static PYProgramNode buildPythonAstFromFile(String filePath) throws Exception {
//        String source = Files.readString(Path.of(filePath));
//        CharStream input = CharStreams.fromString(source);
//        FlaskLexer lexer = new FlaskLexer(input);
//        CommonTokenStream tokens = new CommonTokenStream(lexer);
//        FlaskParser parser = new FlaskParser(tokens);
//        ParseTree parseTree = parser.program();
//        FlaskVisitor pythonAstBuilder = new FlaskVisitor();
//        return (PYProgramNode) pythonAstBuilder.visit(parseTree);
//    }
//
//    private static HtmlDocument buildAstFromFile(String filePath, AstBuilderVisitor astBuilder) throws Exception {
//        String source = Files.readString(Path.of(filePath));
//        CharStream input = CharStreams.fromString(source);
//        HtmlLexer lexer = new HtmlLexer(input);
//        CommonTokenStream tokens = new CommonTokenStream(lexer);
//        HtmlParser parser = new HtmlParser(tokens);
//        ParseTree parseTree = parser.htmlDocument();
//        return (HtmlDocument) astBuilder.visit(parseTree);
//    }
//
//    private static void copyStaticFile(String sourcePath, String destPath) {
//        try {
//            Path src = Paths.get(sourcePath);
//            if (Files.exists(src)) {
//                Files.copy(src, Paths.get(destPath), StandardCopyOption.REPLACE_EXISTING);
//                System.out.println("📋 Copied file: " + sourcePath + " -> " + destPath);
//            }
//        } catch (IOException e) {
//            System.err.println("⚠️ Could not copy file " + sourcePath);
//        }
//    }  }


import ASTHCJ.HtmlDocument;
import SymbolTableHCJ.SymbolTable;
import VisitorHCJ.AstBuilderVisitor;
import VisitorHCJ.VisitorHJC;
import htmlCSS.HtmlLexer;
import htmlCSS.HtmlParser;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws Exception {

        // =========================================================
        // 1. تحديد مسار المشروع بنفس طريقة AppServer
        // =========================================================

        Path projectRoot = Paths.get("")
                .toAbsolutePath()
                .normalize();

        Path sourceRoot = projectRoot

                .resolve("src");

        Path templatesRoot = sourceRoot.resolve("TestHtmlCJ");

        System.out.println("==================================================");
        System.out.println("📁 PROJECT ROOT");
        System.out.println("==================================================");
        System.out.println(projectRoot);

        System.out.println("\n📁 TEMPLATES DIRECTORY");
        System.out.println(templatesRoot);


        // =========================================================
        // 2. أسماء القوالب الثلاثة
        // =========================================================

        Path productsTemplate =
                templatesRoot.resolve("products_template1.html");

        Path addProductTemplate =
                templatesRoot.resolve("add_product_template1.html");

        Path detailsTemplate =
                templatesRoot.resolve("details_template1.html");


        // =========================================================
        // 3. معالجة القالب الأول
        // =========================================================

        processTemplate(
                "PRODUCTS TEMPLATE",
                productsTemplate
        );


        // =========================================================
        // 4. معالجة القالب الثاني
        // =========================================================

        processTemplate(
                "ADD PRODUCT TEMPLATE",
                addProductTemplate
        );


        // =========================================================
        // 5. معالجة القالب الثالث
        // =========================================================

        processTemplate(
                "DETAILS TEMPLATE",
                detailsTemplate
        );


        System.out.println("\n==================================================");
        System.out.println("✅ انتهى تحليل القوالب الثلاثة");
        System.out.println("AST + SYMBOL TABLE فقط");
        System.out.println("==================================================");
    }


    // =============================================================
    // معالجة قالب واحد
    // =============================================================

    private static void processTemplate(
            String templateName,
            Path filePath
    ) throws IOException {

        System.out.println("\n\n");
        System.out.println("##################################################");
        System.out.println("📄 " + templateName);
        System.out.println("##################################################");

        System.out.println("📍 File:");
        System.out.println(filePath);


        // ---------------------------------------------------------
        // التأكد أن الملف موجود
        // ---------------------------------------------------------

        if (!Files.exists(filePath)) {

            System.err.println(
                    "❌ الملف غير موجود: " + filePath
            );

            return;
        }


        // ---------------------------------------------------------
        // قراءة القالب
        // ---------------------------------------------------------

        String source = Files.readString(filePath);


        // ---------------------------------------------------------
        // Lexer
        // ---------------------------------------------------------

        CharStream input =
                CharStreams.fromString(source);

        HtmlLexer lexer =
                new HtmlLexer(input);

        CommonTokenStream tokens =
                new CommonTokenStream(lexer);


        // ---------------------------------------------------------
        // Parser
        // ---------------------------------------------------------

        HtmlParser parser =
                new HtmlParser(tokens);

        ParseTree parseTree =
                parser.htmlDocument();


        // ---------------------------------------------------------
        // بناء AST
        // ---------------------------------------------------------

        AstBuilderVisitor astBuilder =
                new AstBuilderVisitor();

        HtmlDocument ast =
                (HtmlDocument) astBuilder.visit(parseTree);


        // =========================================================
        // AST
        // =========================================================

        System.out.println("\n");
        System.out.println("========== AST ==========");
        System.out.println("Template: " + templateName);
        System.out.println("=========================");

        VisitorHJC visitor =
                new VisitorHJC();

        ast.accept(visitor);


        // =========================================================
        // SYMBOL TABLE
        // =========================================================

        System.out.println("\n");
        System.out.println("========== SYMBOL TABLE ==========");
        System.out.println("Template: " + templateName);
        System.out.println("==================================");

        SymbolTable.printAllSymbols();


        System.out.println("\n----------------------------------");
        System.out.println("✅ Finished: " + templateName);
        System.out.println("----------------------------------");
    }
}






