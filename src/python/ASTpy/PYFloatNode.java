package python.ASTpy;

public class PYFloatNode extends PYNumberNode {

    private double value;

    public PYFloatNode(int line, double value) {
        super(line,"FloatNumberNode");
        this.value = value;
    }

    public double getValue() { return value; }

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
