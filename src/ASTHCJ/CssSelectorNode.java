package ASTHCJ;
import VisitorHCJ.AstVisitor;


    public class CssSelectorNode extends CssNode {

        private final String text;

        public CssSelectorNode(int lineNumber, String text) {
            super("CssSelector", lineNumber);
            this.text = text;
        }

        public String getText() {
            return text;
        }

        @Override
        public String toString() {
            return "CssSelectorNode{" +
                    "text='" + text + '\'' +
                    '}';
        }

        @Override
        public <T> T accept(AstVisitor<T> visitor) {
            return visitor.visitCssSelector(this);
        }
    }





