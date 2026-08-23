package ASTHCJ;
import VisitorHCJ.AstVisitor;


    public class CssNumberValueNode extends CssValuePartNode {

        private final String value; // نخليه String لتفادي float/double مشاكل

        public CssNumberValueNode(int lineNumber, String value) {
            super("CssNumberValue", lineNumber);
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public <T> T accept(AstVisitor<T> visitor) {
            return visitor.visitCssNumberValue(this);
        }
    }







