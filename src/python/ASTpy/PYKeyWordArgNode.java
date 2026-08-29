package python.ASTpy;

public class PYKeyWordArgNode extends PYArgumentNode {

    private PYIdentifierNode  key;
    private PYExpressionNode value;

    public PYKeyWordArgNode(int line, PYIdentifierNode  key, PYExpressionNode value) {
        super(line, "KeywordArgumentNode");
        this.key = key;
        this.value = value;
    }

    public PYIdentifierNode  getKey() { return key; }
    public PYExpressionNode getValue() { return value; }

    @Override
    public void printDetailed(String prefix, boolean isLast) {
        System.out.println(prefix + (isLast ? "└── " : "├── ") + getNodeName()  + " (Line: " + getLine() + ")");

        String childPrefix = prefix + (isLast ? "    " : "│   ");

        System.out.println(childPrefix + "├── key:");
        key.printDetailed(childPrefix + "│   ", true);

        System.out.println(childPrefix + "└── value:");
        value.printDetailed(childPrefix + "    ", true);
    }

    @Override
    public void printASTStructure(String prefix, boolean isLast) {
        System.out.println(prefix + (isLast ? "└── " : "├── ")
                + getClass().getSimpleName() + " (Line: " + getLine() + ")");

        String childPrefix = prefix + (isLast ? "    " : "│   ");

        key.printASTStructure(childPrefix, false);
        value.printASTStructure(childPrefix, true);
    }

}
