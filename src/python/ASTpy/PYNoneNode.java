package python.ASTpy;

public class PYNoneNode extends PYLiteralNode{

    public PYNoneNode(int line) { super(line, "NoneNode"); }

    @Override
    public void printDetailed(String prefix, boolean isLast) {
        System.out.println(prefix + (isLast ? "└── " : "├── ") + getNodeName() + "(None)"  + " (Line: " + getLine() + ")");
    }

    @Override
    public void printASTStructure(String prefix, boolean isLast) {
        System.out.println(prefix + (isLast ? "└── " : "├── ")
                + getClass().getSimpleName() + " (Line: " + getLine() + ")");
    }


}
