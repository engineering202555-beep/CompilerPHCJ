package ASTHCJ;

import VisitorHCJ.AstVisitor;
      public class J_JinjaVariableNode extends HtmlNode {

      private final J_JinjaExpression expression;

       public J_JinjaVariableNode(J_JinjaExpression expression, int line) {
            super("JinjaVariableNode", line);
            this.expression = expression;
        }

        public J_JinjaExpression getExpression() {
            return expression;
        }

        @Override
        public <T> T accept(AstVisitor<T> visitor) {
            return visitor.visitJinjaVariable(this);
        }
    }


