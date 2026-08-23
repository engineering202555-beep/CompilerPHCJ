package ASTHCJ;

import VisitorHCJ.AstVisitor;

public abstract class AstNode {
    protected final String nodeName;
    protected final int lineNumber;

    public AstNode(String nodeName, int lineNumber) {
        this.nodeName = nodeName;
        this.lineNumber = lineNumber;
    }

    public String getNodeName() {
        return nodeName;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    @Override
    public String toString() {
        return "AstNode{" +
                "nodeName='" + nodeName + '\'' +
                ", lineNumber=" + lineNumber +
                '}';
    }

    // Polymorphism
    public abstract <T> T accept(AstVisitor<T> visitor);
}



