package python.ASTpy;

//app.route
public class PYAttributeExprNode extends PYExpressionNode{

    private PYExpressionNode object;
    private String attribute;

    public PYAttributeExprNode(int line, PYExpressionNode object, String attr) {
        super(line, "AttributeAccessNode");
        this.object = object;
        this.attribute = attr;
    }

    public PYExpressionNode getObject() { return object; }
    public String getAttribute() { return attribute; }

    public void setObject(PYExpressionNode object) {
        this.object = object;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    @Override
    public void printDetailed(String prefix, boolean isLast) {
        System.out.println(prefix + (isLast ? "└── " : "├── ") + "AttributeExprNode"  + " (Line: " + getLine() + ")");

        String childPrefix = prefix + (isLast ? "    " : "│   ");

        System.out.println(childPrefix + "├── object:");
        object.printDetailed(childPrefix + "│   ", false);

        System.out.println(childPrefix + "└── attribute: " + attribute);
    }

    @Override
    public void printASTStructure(String prefix, boolean isLast) {
        System.out.println(prefix + (isLast ? "└── " : "├── ")
                + getClass().getSimpleName() + " (Line: " + getLine() + ")");

        String childPrefix = prefix + (isLast ? "    " : "│   ");
        object.printASTStructure(childPrefix, true);
    }

}
