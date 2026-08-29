package python.ASTpy;

public class PYIntegerNode extends PYNumberNode {

    private int value;

    public PYIntegerNode(int line, int value) {
        super(line , "IntegerNumberNode");
        this.value = value;
    }

    public int getValue() { return value; }

    @Override
    public void printDetailed(String prefix, boolean isLast) {
        System.out.println(prefix + (isLast ? "└── " : "├── ") + getNodeName() + "(" + value + ")"  + " (Line: " + getLine() + ")");
    }

    @Override
    public void printASTStructure(String prefix, boolean isLast) {
        System.out.println(prefix + (isLast ? "└── " : "├── ")
                + getClass().getSimpleName() + " (Line: " + getLine() + ")");
    }

}
