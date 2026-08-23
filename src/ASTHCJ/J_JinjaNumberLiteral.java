package ASTHCJ;
import VisitorHCJ.AstVisitor;
public class J_JinjaNumberLiteral extends J_JinjaLiteral{
        private final String value;

        public J_JinjaNumberLiteral(String value, int lineNumber) {
            super("JinjaNumberLiteral", lineNumber);
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public <T> T accept(AstVisitor<T> visitor) {
            return visitor.visitJinjaNumberLiteral(this);
        }
    }




