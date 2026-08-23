package ASTHCJ;

import VisitorHCJ.AstVisitor;

public class StringValue extends AttributeValue {

    private final String value;

    public StringValue(String value, int lineNumber) {
        super("StringValue", lineNumber);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "StringValue{" +
                "value='" + value + '\'' +
                '}';
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visitStringValue(this);
    }
}
