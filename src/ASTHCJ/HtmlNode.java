package ASTHCJ;

import VisitorHCJ.AstVisitor;

public abstract class HtmlNode extends AstNode {
    protected HtmlNode(String nodeName, int lineNumber) {
        super(nodeName, lineNumber);
    }

    @Override
    public abstract <T> T accept(AstVisitor<T> visitor);
}



