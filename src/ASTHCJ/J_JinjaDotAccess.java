package ASTHCJ;

import VisitorHCJ.AstVisitor;

public class J_JinjaDotAccess extends J_JinjaExpression{

    private final J_JinjaExpression base;
    private final J_JinjaIdentifier property;

    public J_JinjaDotAccess(J_JinjaExpression base, J_JinjaIdentifier property, int lineNumber) {
        super("JinjaDotAccess", lineNumber);
        this.base = base;
        this.property = property;
    }

    public J_JinjaExpression getBase() {
        return base;
    }

    public J_JinjaIdentifier getProperty() {
        return property;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visitJinjaDotAccess(this);
    }



}
