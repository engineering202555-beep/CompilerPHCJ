package ASTHCJ;

import VisitorHCJ.AstVisitor;

public class DoctypeNode extends AstNode {

    private final String value;

    public DoctypeNode(String rawValue, int lineNumber) {
        super("Doctype", lineNumber);
        this.value = rawValue;
    }

    public String getRawValue() {
        return value;
    }

    @Override
    public String toString() {
        return "DoctypeNode{" +
                "Value='" + value + '\'' +
                '}';
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visitDoctype(this);
    }
}
