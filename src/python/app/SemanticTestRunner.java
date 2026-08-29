package python.app;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import python.ASTpy.PYProgramNode;
import python.FlaskLexer;
import python.FlaskParser;
import python.SemanticPY.PythonSemanticAnalyzer;
import python.VisitorPY.FlaskVisitor;

import java.io.IOException;
import java.util.List;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

/**
 * أداة تشغيل مستقلة تماماً لاختبار PythonSemanticAnalyzer فقط (المرحلة 1).
 *
 * لا تلمس أي جزء من src/Main.java (الـ pipeline الكامل) ولا من
 * python/app/Main.java الموجود أصلاً - ملف جديد بالكامل بغرض الاختبار فقط.
 *
 * طريقة التشغيل: انظر تعليمات التشغيل المرفقة في رسالة التسليم.
 */
public class SemanticTestRunner {

    public static void main(String[] args) throws IOException {

        String[] testFiles = {
                "src/Tests/test1.txt",
                "src/Tests/test_undefined_variable.txt",
                "src/Tests/test_scope_error.txt",
                "src/Tests/test_valid_cases.txt",
                "src/Tests/test_type_error.txt",
                "src/Tests/test_type_mismatch.txt"
        };

        for (String path : testFiles) {
            runOnFile(path);
        }
    }

    private static void runOnFile(String path) throws IOException {
        System.out.println("==================================================");
        System.out.println("FILE: " + path);
        System.out.println("==================================================");

        CharStream charStream = fromFileName(path);
        FlaskLexer lexer = new FlaskLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        FlaskParser parser = new FlaskParser(tokens);
        ParseTree tree = parser.program();

        FlaskVisitor visitor = new FlaskVisitor();
        PYProgramNode programAst = (PYProgramNode) visitor.visit(tree);

        PythonSemanticAnalyzer analyzer = new PythonSemanticAnalyzer();
        analyzer.analyze(programAst);

        List<PythonSemanticAnalyzer.PythonSemanticError> errors = analyzer.getErrors();

        if (errors.isEmpty()) {
            System.out.println("No semantic errors found.");
        } else {
            System.out.println(errors.size() + " semantic error(s) found:");
            for (PythonSemanticAnalyzer.PythonSemanticError e : errors) {
                System.out.println("   " + e);
            }
        }
        System.out.println();
    }
}
