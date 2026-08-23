package ASTHCJ;
import VisitorHCJ.AstVisitor;
    public abstract class J_JinjaStatement extends J_JinjaNode {

        protected J_JinjaStatement(String nodeName, int lineNumber) {
            super(nodeName, lineNumber);
        }

        @Override
        public abstract <T> T accept(AstVisitor<T> visitor);
    }

