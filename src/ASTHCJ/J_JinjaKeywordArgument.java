package ASTHCJ;

import VisitorHCJ.AstVisitor;

public class J_JinjaKeywordArgument extends AstNode {

    private final J_JinjaIdentifier name;
    private final J_JinjaExpression value;

    public J_JinjaKeywordArgument(
            J_JinjaIdentifier name,
            J_JinjaExpression value,
            int lineNumber
    ) {
        super("JinjaKeywordArgument", lineNumber);
        this.name = name;
        this.value = value;
    }

    public J_JinjaIdentifier getName() {
        return name;
    }

    public J_JinjaExpression getValue() {
        return value;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visitJinjaKeywordArgument(this);
    }
}