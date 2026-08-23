package ASTHCJ;

import VisitorHCJ.AstVisitor;
import java.util.ArrayList;
import java.util.List;

public class CssCompositeValueNode extends CssValueNode {

    private final List<CssValueNode> parts = new ArrayList<>();


    public CssCompositeValueNode(int lineNumber) {
        super("CssCompositeValue", lineNumber);
    }


    public void addPart(CssValueNode part) {
        if (part != null) {
            parts.add(part);
        }
    }

    public List<CssValueNode> getParts() {
        return parts;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visitCssCompositeValue(this);
    }

    @Override
    public String toString() {
        return "CssCompositeValueNode{" +
                "parts=" + parts +
                '}';
    }
}