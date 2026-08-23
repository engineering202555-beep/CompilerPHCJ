package ASTHCJ;

import VisitorHCJ.AstVisitor;

public class CssDeclarationNode extends CssNode {

    private final String property;
    private CssValueNode value;

    public CssDeclarationNode(String property, int lineNumber) {
        super("CssDeclaration", lineNumber);
        this.property = property;
    }

    public String getProperty() {
        return property;
    }

    public CssValueNode getValue() {
        return value;
    }

    // ✅ setter واضح
    public void setValue(CssValueNode value) {
        this.value = value;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visitCssDeclaration(this);
    }
}