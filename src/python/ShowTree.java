package python;

import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.util.Arrays;
import java.io.IOException;

public class ShowTree {
    // هذه الدالة التي سنناديها من الـ CMD
    public static void main(String[] args) {
        try {
            // المسار الافتراضي لملف الاختبار، فيكِ تغيريه حسب حاجتك
            display("Tests/test1.txt");
        } catch (IOException e) {
            System.err.println("Error: Could not find the test file!");
            e.printStackTrace();
        }
    }

    public static void display(String filePath) throws IOException {
        python.FlaskLexer lexer = new FlaskLexer(CharStreams.fromFileName(filePath));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        python.FlaskParser parser = new FlaskParser(tokens);

        ParseTree tree = parser.program();

        TreeViewer viewer = new TreeViewer(Arrays.asList(parser.getRuleNames()), tree);
        viewer.setScale(1);

        JScrollPane scrollPane = new JScrollPane(viewer);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JFrame frame = new JFrame("Flask Parser AST - " + filePath);
        frame.getContentPane().add(scrollPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }
}