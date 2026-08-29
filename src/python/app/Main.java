package python.app;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import python.ASTpy.PYASTNode;
import python.FlaskLexer;
import python.FlaskParser;
import python.SymbolTable.SymbolTable;
import python.VisitorPY.FlaskVisitor;

import java.io.IOException;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class Main {
    public static void main(String[] args) throws IOException {

        String source = "C:/HTMLCSSJINJA2FLASK/CompilerProject/CompilerProject/src/Tests/test1.txt";
        CharStream charStream = fromFileName(source);
        FlaskLexer lexer = new FlaskLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        FlaskParser parser = new FlaskParser(tokens);
        ParseTree ast = parser.program();
        FlaskVisitor visitor = new FlaskVisitor();
        PYASTNode program = visitor.visit(ast);
        SymbolTable symbolTable = visitor.getSymbolTable();

        symbolTable.printTable();

        if (program != null) {
            program.printDetailed("", true);

            //program.printASTStructure("", true);
        } else {
            System.out.println("فشل بناء شجرة الـ AST");
        }

    }
}
