package ASTHCJ;
import VisitorHCJ.AstVisitor;

import java.util.List;
public class PairedTag extends HtmlElement {

    private final List<AstNode> children;

    public PairedTag(
            String tagName,
            List<HtmlAttribute> attributes,
            List<AstNode> children,
            int lineNumber
    ) {
        super("PairedTag", lineNumber, tagName, attributes);
        this.children = children != null ? children : List.of();
    }

    public List<AstNode> getChildren() {
        return children;
    }
    @Override
    public String toString() {
        return "PairedTag{" +
                "tagName='" + tagName + '\'' +
                ", attributesCount=" + attributes.size() +
                ", childrenCount=" + children.size() +
                ", line=" + getLineNumber() +
                '}';
    }
    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visitPairedTag(this);
    }
}
