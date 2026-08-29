package python.ASTpy;

public class PYExprStmtNode extends PYStatementNode{

    private PYExpressionNode expression;

    public PYExprStmtNode(int line, PYExpressionNode expression) {
        super(line, "ExpressionStatementNode");
        this.expression = expression;
    }

    public PYExpressionNode getExpression() {
        return expression;
    }

    @Override
    public void printDetailed(String prefix, boolean isLast){
        System.out.println(prefix + (isLast ? "└── " : "├── ") + getNodeName() + " (Line: " + getLine() + ")");

        if (expression != null) {
            String childPrefix = prefix + (isLast ? "    " : "│   ");
            System.out.println(childPrefix + "└── expression:");
            expression.printDetailed(childPrefix + "    ", true);
        }
    }

    @Override
    public void printASTStructure(String prefix, boolean isLast){
        System.out.println(prefix + (isLast ? "└── " : "├── ")
                + getClass().getSimpleName() + " (Line: " + getLine() + ")");

        if (expression != null) {
            String childPrefix = prefix + (isLast ? "    " : "│   ");
            expression.printASTStructure(childPrefix, true);
        }

    }

}
