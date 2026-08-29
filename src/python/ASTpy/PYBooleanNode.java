package python.ASTpy;

public class PYBooleanNode extends PYLiteralNode {

    private boolean value;

    public PYBooleanNode(int line, boolean val) { super(line, "BooleanNode"); this.value = val; }

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
