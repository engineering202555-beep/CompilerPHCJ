package ASTHCJ;



import VisitorHCJ.AstVisitor;

    public class CssIdentifierValueNode extends CssValuePartNode {

        private final String name;

        public CssIdentifierValueNode(int lineNumber, String name) {
            super("CssIdentifierValue", lineNumber);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public <T> T accept(AstVisitor<T> visitor) {
            return visitor.visitCssIdentifierValue(this);
        }
    }





