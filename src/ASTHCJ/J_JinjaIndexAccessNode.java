package ASTHCJ;


import VisitorHCJ.AstVisitor;

public class J_JinjaIndexAccessNode extends J_JinjaExpression{

        private final J_JinjaExpression target;
        private final J_JinjaExpression index;

        public J_JinjaIndexAccessNode(int lineNumber,
                                      J_JinjaExpression target,
                                      J_JinjaExpression index) {
            super("JinjaIndexAccess", lineNumber);
            this.target = target;
            this.index = index;
        }

    public J_JinjaExpression getTarget() {
        return target;
    }

    public J_JinjaExpression getIndex() {
        return index;
    }
    @Override
        public <T> T accept(AstVisitor<T> visitor) {
            return visitor.visitJinjaIndexAccessNode(this);
        }
    }


