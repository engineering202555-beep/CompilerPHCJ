package ASTHCJ;

import VisitorHCJ.AstVisitor;

public class BooleanAttribute extends HtmlAttribute {

    public BooleanAttribute(String name, int lineNumber) {
        super(name, lineNumber);
    }

    @Override
    public String toString() {
        return "BooleanAttribute{" +
                "name='" + name + '\'' +
                ", line=" + getLineNumber() +
                '}';
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visitBooleanAttribute(this);
    }
}
