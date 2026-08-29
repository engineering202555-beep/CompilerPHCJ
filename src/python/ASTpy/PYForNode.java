package python.ASTpy;

import java.util.ArrayList;
import java.util.List;

public class PYForNode extends PYStatementNode {

    private PYIdentifierNode target; // اسم المتغير مثلا 'p'
    private PYExpressionNode iterable; // المصفوفة مثلا 'products'
    private PYBlockSuiteNode body;

    public PYForNode(int line, PYIdentifierNode target, PYExpressionNode iterable) {
        super(line, "ForNode");
        this.target = target;
        this.iterable = iterable;
    }

    public void setBody(PYBlockSuiteNode body) {
        this.body = body;
    }


    public PYIdentifierNode getTarget() { return target; }
    public PYExpressionNode getIterable() { return iterable; }
    public PYBlockSuiteNode getBody() { return body; }

    @Override
    public void printDetailed(String prefix, boolean isLast) {
        System.out.println(prefix + (isLast ? "└── " : "├── ") + getNodeName()  + " (Line: " + getLine() + ")");

        String childPrefix = prefix + (isLast ? "    " : "│   ");

        if (target != null) {
            System.out.println(childPrefix + "├── target:");
            target.printDetailed(childPrefix + "│   ", true);
        }

        if (iterable != null) {
            System.out.println(childPrefix + "├── iterable:");
            iterable.printDetailed(childPrefix + "│   ", true);
        }

        if (body != null) {
            System.out.println(childPrefix + "└── body:");
            body.printDetailed(childPrefix + "    ", true);
        }
    }


    @Override
    public void printASTStructure(String prefix, boolean isLast) {
        System.out.println(prefix + (isLast ? "└── " : "├── ") + getClass().getSimpleName() + " (Line: " + getLine() + ")");

        String childPrefix = prefix + (isLast ? "    " : "│   ");

        if (target != null)
            target.printASTStructure(childPrefix, false);
        if (iterable != null)
            iterable.printASTStructure(childPrefix, false);
        if (body != null)
            body.printASTStructure(childPrefix, true);
    }

}
