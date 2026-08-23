package ASTHCJ;
import VisitorHCJ.AstVisitor;
public class J_JinjaIdentifier extends J_JinjaExpression{

        private final String name;

        public J_JinjaIdentifier(String name, int lineNumber) {
            super("J_JinjaIdentifier", lineNumber);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public <T> T accept(AstVisitor<T> visitor) {
            return visitor.visitJinjaIdentifier(this);
        }
    }




