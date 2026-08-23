package ASTHCJ;



import VisitorHCJ.AstVisitor;
import java.util.List;

    public class CssFunctionValueNode extends CssValuePartNode {

        private final String functionName;
        private final List<CssValuePartNode> arguments;

        public CssFunctionValueNode(
                int lineNumber,
                String functionName,
                List<CssValuePartNode> arguments) {

            super("CssFunctionValue", lineNumber);
            this.functionName = functionName;
            this.arguments = arguments;
        }

        public String getFunctionName() {
            return functionName;
        }

        public List<CssValuePartNode> getArguments() {
            return arguments;
        }

        @Override
        public <T> T accept(AstVisitor<T> visitor) {
            return visitor.visitCssFunctionValue(this);
        }
    }














