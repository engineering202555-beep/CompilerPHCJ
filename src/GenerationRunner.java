import ASTHCJ.*;
import VisitorHCJ.*;
import htmlCSS.*;

import python.ASTpy.PYProgramNode;
import python.FlaskLexer;
import python.FlaskParser;
import python.VisitorPY.FlaskContextExtractor;
import python.VisitorPY.FlaskVisitor;

import java.io.IOException;
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
 * يشغّل الـ pipeline الحقيقي بالكامل للـ Code Generation:
 *
 *   Python  -> FlaskLexer -> FlaskParser -> FlaskVisitor -> PYProgramNode
 *           -> FlaskContextExtractor -> Context Data + Routes
 *   HTML/Jinja (لكل قالب) -> HtmlLexer -> HtmlParser -> AstBuilderVisitor
 *           -> HtmlDocument -> SemanticAnalyzerVisitor (بوابة حماية)
 *           -> CodeGeneratorVisitor -> output/<name>.html
 *
 * لا يبني أي AST يدوياً. لا يلمس src/Main.java. لا يعدّل SemanticAnalyzerVisitor
 * أو PythonSemanticAnalyzer أو أي grammar.
 */

public class GenerationRunner {

    private static final StringBuilder log = new StringBuilder();

    public static void main(String[] args) throws Exception {

        String outputDir = "output/";
        String compilerOutputDir = "compiler_output/";
        Files.createDirectories(Paths.get(outputDir));
        Files.createDirectories(Paths.get(compilerOutputDir));

        logLine("Generation started at: " + LocalDateTime.now());

        // ================= Python =================
        String pythonFilePath = "src/Tests/test1.txt";
        PYProgramNode pythonAst = buildPythonAstFromFile(pythonFilePath);

        FlaskContextExtractor extractor = new FlaskContextExtractor();
        extractor.extract(pythonAst);

        List<String> liveFlaskVariables = extractor.getExtractedVariables();
        List<String> flaskFunctionsList = extractor.getExtractedFunctions();
        Map<String, Object> contextData = extractor.getExtractedContextData();
        Map<String, String> routes = extractor.getExtractedRoutes();

        System.out.println("Context Data: " + contextData);
        System.out.println("Routes: " + routes);
        logLine("Python source: " + pythonFilePath);
        logLine("Extracted routes: " + routes);
        logLine("Extracted context keys: " + contextData.keySet());
        logLine("");

        // ================= HTML/CSS/Jinja =================
        String[] templates = {
                "products_template.html",
                "add_product_template.html",
                "details_template.html"
        };

        for (String templateName : templates) {
            generateTemplate(templateName, contextData, routes, liveFlaskVariables, flaskFunctionsList, outputDir);
        }

        // ================= ملفات داعمة (لا تُعالَج، تُنسَخ فقط إن وُجدت) =================
        copyStaticFileIfExists("app.py", outputDir + "app.py");
        copyStaticFileIfExists("style.css", outputDir + "style.css");
        copyStaticFileIfExists("script.js", outputDir + "script.js");

        logLine("Generation finished at: " + LocalDateTime.now());
        Files.writeString(Paths.get(compilerOutputDir + "generation_log.txt"), log.toString());
        System.out.println("\nLog written to: " + compilerOutputDir + "generation_log.txt");
    }

    private static void generateTemplate(String templateName, Map<String, Object> contextData,
                                         Map<String, String> routes, List<String> flaskVariables,
                                         List<String> flaskFunctions, String outputDir) throws Exception {

        String inputPath = "src/TestHtmlCJ/" + templateName;
        String outputPath = outputDir + templateName;

        System.out.println("\n==================================================");
        System.out.println("TEMPLATE: " + templateName);
        System.out.println("==================================================");

        HtmlDocument htmlAst = buildHtmlAstFromFile(inputPath);

        SemanticAnalyzerVisitor semanticAnalyzer = new SemanticAnalyzerVisitor(flaskVariables, flaskFunctions);
        htmlAst.accept(semanticAnalyzer);

        if (semanticAnalyzer.getErrorCount() > 0) {
            System.out.println("ABORTED - semantic errors found:");
            for (String err : semanticAnalyzer.getErrors()) System.out.println("  " + err);
            logLine("TEMPLATE: " + templateName + " -> ABORTED (semantic errors: " + semanticAnalyzer.getErrorCount() + ")");
            for (String err : semanticAnalyzer.getErrors()) logLine("   " + err);
            return;
        }

        CodeGeneratorVisitor generator = new CodeGeneratorVisitor();
        generator.setContext(contextData);
        generator.setRoutes(routes);
        generator.generateOutput(htmlAst, outputPath, flaskVariables, flaskFunctions);

        String generatedContent = Files.readString(Path.of(outputPath));
        boolean stillHasJinja = generatedContent.contains("{{") || generatedContent.contains("{%");

        System.out.println("Output: " + outputPath);
        System.out.println("Remaining Jinja syntax in output: " + stillHasJinja);

        logLine("TEMPLATE: " + templateName);
        logLine("  input:  " + inputPath);
        logLine("  output: " + outputPath);
        logLine("  semantic errors: 0");
        logLine("  remaining Jinja syntax ({{ or {%) in output: " + stillHasJinja);
        logLine("");
    }

    private static PYProgramNode buildPythonAstFromFile(String filePath) throws Exception {
        String source = Files.readString(Path.of(filePath));
        CharStream input = CharStreams.fromString(source);
        FlaskLexer lexer = new FlaskLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        FlaskParser parser = new FlaskParser(tokens);
        ParseTree parseTree = parser.program();
        FlaskVisitor pythonAstBuilder = new FlaskVisitor();
        return (PYProgramNode) pythonAstBuilder.visit(parseTree);
    }

    private static HtmlDocument buildHtmlAstFromFile(String filePath) throws Exception {
        String source = Files.readString(Path.of(filePath));
        CharStream input = CharStreams.fromString(source);
        HtmlLexer lexer = new HtmlLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        HtmlParser parser = new HtmlParser(tokens);
        ParseTree parseTree = parser.htmlDocument();
        AstBuilderVisitor astBuilder = new AstBuilderVisitor();
        return (HtmlDocument) astBuilder.visit(parseTree);
    }

    private static void copyStaticFileIfExists(String sourcePath, String destPath) {
        try {
            Path src = Paths.get(sourcePath);
            if (Files.exists(src)) {
                Files.copy(src, Paths.get(destPath), StandardCopyOption.REPLACE_EXISTING);
                logLine("Copied supporting file: " + sourcePath + " -> " + destPath);
            } else {
                logLine("Supporting file not found (skipped, not generated): " + sourcePath);
            }
        } catch (IOException e) {
            logLine("Could not copy supporting file " + sourcePath + ": " + e.getMessage());
        }
    }

    private static void logLine(String text) {
        log.append(text).append("\n");
    }
}