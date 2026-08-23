package ASTHCJ;


import VisitorHCJ.AstVisitor;
import java.util.ArrayList;
import java.util.List;

public class CssStyleSheetNode extends CssNode {

    private final List<CssRuleNode> rules = new ArrayList<>();

    public CssStyleSheetNode(int lineNumber) {
        super("CssStyleSheet", lineNumber);
    }

    public void addRule(CssRuleNode rule) {
        if (rule != null) {
            rules.add(rule);
        }
    }

    public List<CssRuleNode> getRules() {
        return rules;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visitCssStyleSheet(this);
    }
}




