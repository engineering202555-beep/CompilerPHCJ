package ASTHCJ;


import VisitorHCJ.AstVisitor;

public class J_JinjaFilterNode extends J_JinjaExpression{

        private final J_JinjaExpression expression;
        private final String filterName;

        public J_JinjaFilterNode(int lineNumber,
                               J_JinjaExpression expression,
                               String filterName) {
            super("JinjaFilter", lineNumber);
            this.expression = expression;
            this.filterName = filterName;
        }

    public J_JinjaExpression getExpression() {
        return expression;
    }

    public String getFilterName() {
        return filterName;
    }

    @Override
        public <T> T accept(AstVisitor<T> visitor) {
            return visitor.visitJinjaFilterNode(this);
        }
    }

