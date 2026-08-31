import ASTHCJ.*;
import VisitorHCJ.*;
import htmlCSS.*;

import python.ASTpy.PYProgramNode;
import python.FlaskLexer;
import python.FlaskParser;
import python.SemanticPY.PythonSemanticAnalyzer;
import python.VisitorPY.FlaskContextExtractor;
import python.VisitorPY.FlaskVisitor;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * يشغّل الـ pipeline الحقيقي بالكامل (Lexer -> Parser -> Visitor -> AST ->
 * Semantic Analyzer) على كل ملفات الاختبار (Python + HTML/CSS/Jinja)، ثم
 * يجمع كل النتائج ويكتبها في compiler_output/semantic_report.txt عبر
 * SemanticReportWriter.
 *
 * لا يبني أي AST يدوياً - كل شجرة ناتجة فعلياً من نفس الكلاسات التي يستخدمها
 * src/Main.java (FlaskLexer/FlaskParser/FlaskVisitor لبايثون،
 * HtmlLexer/HtmlParser/AstBuilderVisitor لـ HTML/CSS/Jinja).
 *
 * ملف جديد بالكامل - لا يلمس src/Main.java.
 */
public class SemanticReportRunner {

    public static void main(String[] args) throws Exception {

        SemanticReportWriter writer = new SemanticReportWriter();

        // ================= Python =================
        String[] pythonTestFiles = {
                "src/Tests/test1.txt",
                "src/Tests/test_undefined_variable.txt",
                "src/Tests/test_scope_error.txt",
                "src/Tests/test_type_error.txt",
                "src/Tests/test_type_mismatch.txt",
                "src/Tests/test_valid_cases.txt"
        };

        for (String path : pythonTestFiles) {
            PYProgramNode programAst = buildPythonAstFromFile(path);
            PythonSemanticAnalyzer analyzer = new PythonSemanticAnalyzer();
            analyzer.analyze(programAst);
            writer.addPythonFileSection(fileNameOnly(path), analyzer.getErrors());
        }

        // ================= HTML/CSS/Jinja =================
        // سياق Flask حقيقي مستخرج من test1.txt (نفس آلية Main.java)، حتى تكون
        // فحوصات Jinja (Missing Flask Variable, Route checks...) صحيحة إن
        // وُجدت داخل أي من ملفات test_css_*.html
        PYProgramNode pythonAstForContext = buildPythonAstFromFile("src/Tests/test1.txt");
        FlaskContextExtractor extractor = new FlaskContextExtractor();
        extractor.extract(pythonAstForContext);
        List<String> liveFlaskVariables = extractor.getExtractedVariables();
        List<String> flaskFunctionsList = extractor.getExtractedFunctions();

        String[] htmlTestFiles = {
                "src/TestHtmlCJ/test_css_valid.html",
                "src/TestHtmlCJ/test_css_unknown_property.html",
                "src/TestHtmlCJ/test_css_type_mismatch_color.html",
                "src/TestHtmlCJ/test_css_type_mismatch_padding.html",
                "src/TestHtmlCJ/test_css_repeated_property.html"
        };

        for (String path : htmlTestFiles) {
            HtmlDocument htmlAst = buildHtmlAstFromFile(path);
            SemanticAnalyzerVisitor analyzer = new SemanticAnalyzerVisitor(liveFlaskVariables, flaskFunctionsList);
            htmlAst.accept(analyzer);
            writer.addHtmlFileSection(fileNameOnly(path), analyzer.getErrors());
        }

        // ================= كتابة التقرير =================
        String reportPath = "compiler_output/semantic_report.txt";
        writer.writeToFile(reportPath);

        System.out.println("Report written to: " + reportPath);
        System.out.println();
        System.out.println(writer.getReportText());
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

    private static String fileNameOnly(String path) {
        return Path.of(path).getFileName().toString();
    }
}
 