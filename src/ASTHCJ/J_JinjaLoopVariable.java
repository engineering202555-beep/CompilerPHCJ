package ASTHCJ;

import VisitorHCJ.AstVisitor;

public class J_JinjaLoopVariable extends AstNode {

    private final String name;

    public J_JinjaLoopVariable(String name, int lineNumber) {
        super("J_JinjaLoopVariable", lineNumber);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visitJinjaLoopVariable(this);
    }
}