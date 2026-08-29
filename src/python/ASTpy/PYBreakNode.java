package python.ASTpy;

public class PYBreakNode extends PYStatementNode{

    public PYBreakNode(int line) {
        super(line, "BreakNode");
    }

    @Override
    public void printDetailed(String prefix, boolean isLast) {
        System.out.println(
                prefix +
                        (isLast ? "└── " : "├── ") +
                        "BreakNode"  + " (Line: " + getLine() + ")"
        );
    }

    @Override
    public void printASTStructure(String prefix, boolean isLast) {
        System.out.println(
                prefix +
                        (isLast ? "└── " : "├── ") +
                        getClass().getSimpleName() +
                        " (Line: " + getLine() + ")"
        );
    }

}
