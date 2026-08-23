package ASTHCJ;



import VisitorHCJ.AstVisitor;

    public class CssColorValueNode extends CssValuePartNode {

        private final String color;

        public CssColorValueNode(int lineNumber, String color) {
            super("CssColorValue", lineNumber);
            this.color = color;
        }

        public String getColor() {
            return color;
        }

        @Override
        public <T> T accept(AstVisitor<T> visitor) {
            return visitor.visitCssColorValue(this);
        }
    }


