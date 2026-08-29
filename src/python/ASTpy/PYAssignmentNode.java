package python.ASTpy;

public class PYAssignmentNode extends PYStatementNode {

    private PYExpressionNode target;
    private PYExpressionNode value;

    public PYAssignmentNode(int line, PYExpressionNode target, PYExpressionNode value) {
        super(line, "AssignmentNode");
        this.target = target;
        this.value = value;
    }

    @Override
    public void printDetailed(String prefix, boolean isTail) {
        System.out.println(
                prefix +
                        (isTail ? "└── " : "├── ") +
                        "AssignmentNode"  + " (Line: " + getLine() + ")"
        ) ;

        String childPrefix = prefix + (isTail ? "    " : "│   ");

        System.out.println(childPrefix + "├── target:");
        target.printDetailed(childPrefix + "│   ", false);

        System.out.println(childPrefix + "└── value:");
        value.printDetailed(childPrefix + "    ", true);
    }

    @Override
    public void printASTStructure(String prefix, boolean isLast) {
        System.out.println(
                prefix +
                        (isLast ? "└── " : "├── ") +
                        getClass().getSimpleName() +
                        " (Line: " + getLine() + ")"
        );

        String childPrefix = prefix + (isLast ? "    " : "│   ");

        target.printASTStructure(childPrefix, false);

        value.printASTStructure(childPrefix, true);
    }

    public PYExpressionNode getTarget() { return target; }
    public PYExpressionNode getValue() { return value; }

}
