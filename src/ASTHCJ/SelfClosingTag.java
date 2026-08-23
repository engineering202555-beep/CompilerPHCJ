package ASTHCJ;

import VisitorHCJ.AstVisitor;

import java.util.List;

public  class SelfClosingTag extends HtmlElement {

    public SelfClosingTag(
            String tagName,
            List<HtmlAttribute> attributes,
            int lineNumber
    ) {
        super("SelfClosingTag", lineNumber, tagName, attributes);
    }
    @Override
    public String toString() {
        return "SelfClosingTag{" +
                "tagName='" + tagName + '\'' +
                ", attributesCount=" + attributes.size() +
                ", line=" + getLineNumber() +
                '}';
    }
    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visitSelfClosingTag(this);
    }
}
