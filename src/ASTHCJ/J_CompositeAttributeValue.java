package ASTHCJ;

import VisitorHCJ.AstVisitor;
import java.util.List;

public class J_CompositeAttributeValue extends AttributeValue {

    private final List<AstNode> parts;  // قائمة الأجزاء المكونة للقيمة (JinjaExpr أو StringLiteral)

    public J_CompositeAttributeValue(List<AstNode> parts, int lineNumber) {
        super("CompositeAttributeValue", lineNumber);
        this.parts = parts;
    }

    public List<AstNode> getParts() {
        return parts;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visitCompositeAttributeValue(this);
    }
}