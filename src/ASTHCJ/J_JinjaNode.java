package ASTHCJ;

import VisitorHCJ.AstVisitor;

public abstract class J_JinjaNode extends AstNode {

    protected J_JinjaNode(String nodeName, int lineNumber) {
        super(nodeName, lineNumber);
    }

    @Override
    public abstract <T> T accept(AstVisitor<T> visitor);
}
