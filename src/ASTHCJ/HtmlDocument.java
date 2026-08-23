package ASTHCJ;
import VisitorHCJ.AstVisitor;

import java.util.List;
public class HtmlDocument extends AstNode {

    private final DoctypeNode doctype;
    private final List<HtmlNode> nodes;

    public HtmlDocument(
            DoctypeNode doctype,
            List<HtmlNode> nodes,
            int lineNumber
    ) {
        super("HtmlDocument", lineNumber);
        this.doctype = doctype;
        this.nodes = nodes;
    }

    public DoctypeNode getDoctype() {
        return doctype;
    }

    public List<HtmlNode> getNodes() {
        return nodes;
    }

    @Override
    public String toString() {
        return "HtmlDocument{" +
                "doctype=" + (doctype != null ? doctype : "none") +
                ", nodesCount=" + (nodes != null ? nodes.size() : 0) +
                ", line=" + getLineNumber() +
                '}';
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visitHtmlDocument(this);
    }
}