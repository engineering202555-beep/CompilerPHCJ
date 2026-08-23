package ASTHCJ;

import VisitorHCJ.AstVisitor;

public class StyleContent extends HtmlNode {

    private final CssStyleSheetNode css;

    public StyleContent(CssStyleSheetNode css, int lineNumber) {
        super("StyleContent", lineNumber);
        this.css = css;
    }

    public CssStyleSheetNode getCss() {
        return css;
    }

    @Override
    public String toString() {
        return "StyleContent{" +
                "css='" + css + '\'' +
                '}';
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visitStyleContent(this);
    }
}
