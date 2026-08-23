package ASTHCJ;
import VisitorHCJ.AstVisitor;

    public abstract class J_JinjaLiteral extends J_JinjaExpression {

        protected J_JinjaLiteral(String nodeName, int lineNumber) {
            super(nodeName, lineNumber);
        }

        @Override
        public abstract <T> T accept(AstVisitor<T> visitor);
    }




