import ASTHCJ.*;
import VisitorHCJ.*;
import htmlCSS.*;

import python.ASTpy.PYProgramNode;
import python.FlaskLexer;
import python.FlaskParser;
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
 * أداة تشغيل مستقلة لاختبار CSS/HTML/Jinja Semantic Analysis عبر الـ pipeline
 * الحقيقي بالكامل: HtmlLexer -> HtmlParser -> AstBuilderVisitor -> HtmlDocument
 * AST -> SemanticAnalyzerVisitor. لا تلمس src/Main.java إطلاقاً.
 *
 * سياق Flask الحقيقي يُستخرَج من src/Tests/test1.txt بنفس الطريقة تماماً التي
 * يستخدمها src/Main.java (عبر FlaskContextExtractor)، حتى تكون نتائج فحوصات
 * Jinja (Missing Flask Variable, Route checks, ...) مطابقة لما ينتجه المشروع
 * فعلياً، وليست نتائج مصطنعة بسبب تمرير قوائم فارغة.
 */
public class CssSemanticTestRunner {

    public static void main(String[] args) throws Exception {

        // نفس آلية Main.java تماماً: استخراج سياق Flask الحقيقي من ملف بايثون حقيقي
        String pythonFilePath = "src/Tests/test1.txt";
        PYProgramNode pythonAst = buildPythonAstFromFile(pythonFilePath);
        FlaskContextExtractor extractor = new FlaskContextExtractor();
        extractor.extract(pythonAst);
        List<String> liveFlaskVariables = extractor.getExtractedVariables();
        List<String> flaskFunctionsList = extractor.getExtractedFunctions();

        System.out.println("Flask variables extracted from " + pythonFilePath + ": " + liveFlaskVariables);
        System.out.println("Flask functions extracted from " + pythonFilePath + ": " + flaskFunctionsList);
        System.out.println();

        String[] testFiles = {
                // ملفات اختبار CSS مُركَّزة (بدون Jinja) - من المرحلة السابقة
                "src/TestHtmlCJ/test_css_valid.html",
                "src/TestHtmlCJ/test_css_unknown_property.html",
                "src/TestHtmlCJ/test_css_type_mismatch_color.html",
                "src/TestHtmlCJ/test_css_type_mismatch_padding.html",
                "src/TestHtmlCJ/test_css_repeated_property.html",
                // ملفات حقيقية موجودة أصلاً في المشروع - تحتوي CSS و Jinja معاً
                "src/TestHtmlCJ/products_template.html",
                "src/TestHtmlCJ/details_template.html",
                "src/TestHtmlCJ/add_product_template.html",

        };

        for (String path : testFiles) {
            runOnFile(path, liveFlaskVariables, flaskFunctionsList);
        }
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

    private static void runOnFile(String path, List<String> liveFlaskVariables, List<String> flaskFunctionsList) throws Exception {
        System.out.println("==================================================");
        System.out.println("FILE: " + path);
        System.out.println("==================================================");

        String source = Files.readString(Path.of(path));
        CharStream input = CharStreams.fromString(source);
        HtmlLexer lexer = new HtmlLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        HtmlParser parser = new HtmlParser(tokens);
        ParseTree parseTree = parser.htmlDocument();

        AstBuilderVisitor astBuilder = new AstBuilderVisitor();
        HtmlDocument htmlAst = (HtmlDocument) astBuilder.visit(parseTree);

        SemanticAnalyzerVisitor analyzer = new SemanticAnalyzerVisitor(liveFlaskVariables, flaskFunctionsList);
        htmlAst.accept(analyzer);

        if (analyzer.getErrorCount() == 0) {
            System.out.println("No semantic errors found.");
        } else {
            analyzer.printErrors();
        }
        System.out.println();
    }
}