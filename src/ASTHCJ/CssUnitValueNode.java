package ASTHCJ;
import VisitorHCJ.AstVisitor;
    public class CssUnitValueNode extends CssValuePartNode {

        private final String unit; // px, em, %

        public CssUnitValueNode(int lineNumber, String unit) {
            super("CssUnitValue", lineNumber);
            this.unit = unit;
        }

        public String getUnit() {
            return unit;
        }

        @Override
        public <T> T accept(AstVisitor<T> visitor) {
            return visitor.visitCssUnitValue(this);
        }
    }








