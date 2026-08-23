package ASTHCJ;
import VisitorHCJ.AstVisitor;
public class J_JinjaStringLiteral   extends J_JinjaLiteral {

        private final String value;
        public J_JinjaStringLiteral(String value, int lineNumber) {
            super("JinjaStringLiteral", lineNumber);
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public <T> T accept(AstVisitor<T> visitor) {
            return visitor.visitJinjaStringLiteral(this);
        }
    }




