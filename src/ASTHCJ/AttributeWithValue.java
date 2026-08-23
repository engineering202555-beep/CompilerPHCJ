package ASTHCJ;

import VisitorHCJ.AstVisitor;

public class AttributeWithValue extends HtmlAttribute {

    private final AttributeValue value;

    public AttributeWithValue(
            String name,
            AttributeValue value,
            int lineNumber
    ) {
        super(name, lineNumber);
        this.value = value;
    }

    public AttributeValue getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "AttributeWithValue{" +
                "value=" + value +
                '}';
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {

        return visitor.visitAttributeWithValue(this);
    }
}
