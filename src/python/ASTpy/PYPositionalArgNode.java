package python.ASTpy;

public class PYPositionalArgNode extends PYArgumentNode {

    private PYExpressionNode value;

    public PYPositionalArgNode(int line, PYExpressionNode value) {
        super(line, "PositionalArgumentNode");
        this.value = value;
    }

    public PYExpressionNode getValue() {
        return value;
    }

    @Override
    public void printDetailed(String prefix, boolean isLast) {
        System.out.println(prefix + (isLast ? "└── " : "├── ") + getNodeName()  + " (Line: " + getLine() + ")");

        String childPrefix = prefix + (isLast ? "    " : "│   ");

        System.out.println(childPrefix + "└── value:");
        value.printDetailed(childPrefix + "    ", true);
    }

    @Override
    public void printASTStructure(String prefix, boolean isLast) {
        System.out.println(prefix + (isLast ? "└── " : "├── ")
                + getClass().getSimpleName() + " (Line: " + getLine() + ")");

        String childPrefix = prefix + (isLast ? "    " : "│   ");
        value.printASTStructure(childPrefix, true);
    }
}
