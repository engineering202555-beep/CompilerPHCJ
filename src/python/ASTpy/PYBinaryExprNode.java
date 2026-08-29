package python.ASTpy;

public class PYBinaryExprNode extends PYExpressionNode{

    private PYExpressionNode left;
    private String operator;        // العملية (+, -, *, /, ==, >, and, or, ...)
    private PYExpressionNode right;

    public PYBinaryExprNode(int line, PYExpressionNode left, String operator, PYExpressionNode right) {
        super(line, "BinaryExpressionNode");
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    public PYExpressionNode getLeft() { return left; }
    public String getOperator() { return operator; }
    public PYExpressionNode getRight() { return right; }

    @Override
    public void printDetailed(String prefix, boolean isLast) {
        System.out.println(prefix + (isLast ? "└── " : "├── ") + getNodeName()  + " (Line: " + getLine() + ")");
        String childPrefix = prefix + (isLast ? "    " : "│   ");

        // left
        System.out.println(childPrefix + "├── left:");
        left.printDetailed(childPrefix + "│   ", false);

        // operator
        System.out.println(childPrefix + "├── operator: \"" + operator + "\"");

        // right
        System.out.println(childPrefix + "└── right:");
        right.printDetailed(childPrefix + "    ", true);
    }


    @Override
    public void printASTStructure(String prefix, boolean isLast) {
        System.out.println(prefix + (isLast ? "└── " : "├── ") +
                getClass().getSimpleName() + " (Line: " + getLine() + ")");
        String childPrefix = prefix + (isLast ? "    " : "│   ");

        left.printASTStructure(childPrefix, false);
        right.printASTStructure(childPrefix, true);
    }

}
