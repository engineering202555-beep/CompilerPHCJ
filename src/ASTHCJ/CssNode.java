package ASTHCJ;

import VisitorHCJ.AstVisitor;

public abstract class CssNode extends AstNode {

    protected CssNode(String nodeName, int lineNumber) {
        super(nodeName, lineNumber);
    }
    @Override
    public abstract <T> T accept(AstVisitor<T> visitor);

}
