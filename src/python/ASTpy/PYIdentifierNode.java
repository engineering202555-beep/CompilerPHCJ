package python.ASTpy;

public class PYIdentifierNode extends PYExpressionNode{

    private String  name;

    public PYIdentifierNode(int line, String  name) {
        super(line, "IdentifierNode");
        this.name = name;
    }

    public String  getName() {
        return name;
    }

    @Override
    public void printDetailed(String prefix, boolean isLast) {

        System.out.println(
                prefix
                        + (isLast ? "└── " : "├── ")
                        + "IdentifierNode(\"" + name + "\")"  + " (Line: " + getLine() + ")"
        );

    }

    @Override
    public void printASTStructure(String prefix, boolean isLast) {
        System.out.println(
                prefix
                        + (isLast ? "└── " : "├── ")
                        + getClass().getSimpleName()
                        + " (Line: " + getLine() + ")"
        );
    }

}
