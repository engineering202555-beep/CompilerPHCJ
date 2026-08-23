package ASTHCJ;
import VisitorHCJ.AstVisitor;
public abstract class J_JinjaExpression extends J_JinjaNode {

        protected J_JinjaExpression(String nodeName, int lineNumber) {
            super(nodeName, lineNumber);
        }

        @Override
        public abstract <T> T accept(AstVisitor<T> visitor);
    }
