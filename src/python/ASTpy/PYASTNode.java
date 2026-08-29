package python.ASTpy;

public abstract class PYASTNode {

    private int lineNumber;
    private String nodeName;

    public PYASTNode(int lineNumber, String nodeName) {
        this.lineNumber = lineNumber;
        this.nodeName = nodeName;
    }

    public int getLine() { return lineNumber; }
    public String getNodeName() { return nodeName; }

    //////////////////////////////////
    public abstract void printDetailed
    (String prefix, boolean isLast);

    public abstract void printASTStructure
            (String prefix, boolean isLast);

}
