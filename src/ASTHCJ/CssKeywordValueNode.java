package ASTHCJ;



import VisitorHCJ.AstVisitor;

    public class CssKeywordValueNode extends CssValuePartNode {

        private final String keyword;

        public CssKeywordValueNode(int lineNumber, String keyword) {
            super("CssKeywordValue", lineNumber);
            this.keyword = keyword;
        }

        public String getKeyword() {
            return keyword;
        }

        @Override
        public <T> T accept(AstVisitor<T> visitor) {
            return visitor.visitCssKeywordValue(this);
        }
    }













