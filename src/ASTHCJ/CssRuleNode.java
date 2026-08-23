package ASTHCJ;

import VisitorHCJ.AstVisitor;
import java.util.ArrayList;
import java.util.List;

public class CssRuleNode extends CssNode {

    private CssSelectorNode selector;
    private final List<CssDeclarationNode> declarations = new ArrayList<>();

    // ✅ constructor يأخذ فقط lineNumber
    public CssRuleNode(int lineNumber) {
        super("CssRule", lineNumber);
    }

    // ✅ addSelector
    public void addSelector(CssSelectorNode selector) {
        this.selector = selector;
    }

    public CssSelectorNode getSelector() {
        return selector;
    }

    // ✅ addDeclaration
    public void addDeclaration(CssDeclarationNode declaration) {
        if (declaration != null) {
            declarations.add(declaration);
        }
    }

    public List<CssDeclarationNode> getDeclarations() {
        return declarations;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visitCssRule(this);
    }

    @Override
    public String toString() {
        return "CssRuleNode{" +
                "selector=" + selector +
                ", declarations=" + declarations +
                '}';
    }
}