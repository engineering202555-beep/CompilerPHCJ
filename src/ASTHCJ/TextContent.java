package ASTHCJ;

import VisitorHCJ.AstVisitor;

public class TextContent extends HtmlNode {

    private final String text;

    public TextContent(String text, int lineNumber) {
        super("TextContent", lineNumber);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "TextContent{" +
                "text='" + text + '\'' +
                '}';
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visitTextContent(this);
    }
}
