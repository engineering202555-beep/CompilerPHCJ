package python.ASTpy;

//request.form['username']
public class PYIndexExprNode extends PYExpressionNode{

    private PYExpressionNode container;
    private PYExpressionNode index;

    public PYIndexExprNode(int line, PYExpressionNode container, PYExpressionNode index) {
        super(line, "IndexAccessNode");
        this.container = container;
        this.index = index;
    }

    public PYExpressionNode getTarget() { return container; }
    public PYExpressionNode getIndex() { return index; }

    public void setContainer(PYExpressionNode container) {
        this.container = container;
    }

    public void setIndex(PYExpressionNode index) {
        this.index = index;
    }

    @Override
    public void printDetailed(String prefix, boolean isLast) {
        System.out.println(prefix + (isLast ? "└── " : "├── ") + getNodeName()  + " (Line: " + getLine() + ")");
        String childPrefix = prefix + (isLast ? "    " : "│   ");

        System.out.println(childPrefix + "├── target:");
        container.printDetailed(childPrefix + "│   ", false);

        System.out.println(childPrefix + "└── index:");
        index.printDetailed(childPrefix + "    ", true);
    }
    @Override
    public void printASTStructure(String prefix, boolean isLast) {
        System.out.println(prefix + (isLast ? "└── " : "├── ") +
                getClass().getSimpleName() + " (Line: " + getLine() + ")");
        String childPrefix = prefix + (isLast ? "    " : "│   ");

        container.printASTStructure(childPrefix, false);
        index.printASTStructure(childPrefix, true);
    }

}
