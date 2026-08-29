package python.ASTpy;

public class PYKeyValueNode extends PYASTNode{

    private PYExpressionNode key;
    private PYExpressionNode value;

    public PYKeyValueNode(int line, PYExpressionNode key, PYExpressionNode value) {
        super(line, "KeyValueNode");
        this.key = key;
        this.value = value;
    }

    public PYExpressionNode getKey() { return key; }
    public PYExpressionNode getValue() { return value; }

    @Override
    public void printDetailed(String prefix, boolean isLast){
        System.out.println(prefix + (isLast ? "└── " : "├── ") + getNodeName()  + " (Line: " + getLine() + ")");

        String childPrefix = prefix + (isLast ? "    " : "│   ");

        System.out.println(childPrefix + "├── key:");
        key.printDetailed(childPrefix + "│   ", false);

        System.out.println(childPrefix + "└── value:");
        value.printDetailed(childPrefix + "    ", true);
    }

    @Override
    public void printASTStructure(String prefix, boolean isLast) {
        System.out.println(prefix + (isLast ? "└── " : "├── ") +
                getClass().getSimpleName() + " (Line: " + getLine() + ")");

        String childPrefix = prefix + (isLast ? "    " : "│   ");

        key.printASTStructure(childPrefix, false);
        value.printASTStructure(childPrefix, true);
    }

}
