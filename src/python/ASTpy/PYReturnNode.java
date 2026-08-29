package python.ASTpy;

public class PYReturnNode extends PYStatementNode {

    private PYExpressionNode value;

    public PYReturnNode(int line, PYExpressionNode value) {
        super(line, "ReturnNode");
        this.value = value;
    }

    public PYExpressionNode getValue() {
        return value;
    }

    @Override
    public void printDetailed(String prefix, boolean isLast) {
        System.out.println(
                prefix +
                        (isLast ? "└── " : "├── ") +
                        "ReturnNode"  + " (Line: " + getLine() + ")"
        );

        String childPrefix = prefix + (isLast ? "    " : "│   ");

        System.out.print(childPrefix + "└── value:");

        if (value == null) {
            System.out.println(" None");
        } else {
            System.out.println();
            value.printDetailed(childPrefix + "    ", true);
        }
    }

    @Override
    public void printASTStructure(String prefix, boolean isLast) {
        System.out.println(
                prefix +
                        (isLast ? "└── " : "├── ") +
                        getClass().getSimpleName() +
                        " (Line: " + getLine() + ")"
        );

        if (value != null) {
            value.printASTStructure(prefix + (isLast ? "    " : "│   "), true);
        }
    }

}
