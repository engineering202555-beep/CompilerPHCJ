package ASTHCJ;
import VisitorHCJ.AstVisitor;
import java.util.List;
    public class J_JinjaFunctionCall extends J_JinjaExpression {

            private final J_JinjaIdentifier functionName;
            private final List<J_JinjaExpression> arguments;  // List of all arguments (including the keyword ones)
            private final List<J_JinjaKeywordArgument> keywordArguments; // New for keyword arguments

            public J_JinjaFunctionCall(J_JinjaIdentifier functionName,
                                       List<J_JinjaExpression> arguments,
                                       List<J_JinjaKeywordArgument> keywordArguments,
                                       int lineNumber) {
                super("JinjaFunctionCall", lineNumber);
                this.functionName = functionName;
                this.arguments = arguments;
                this.keywordArguments = keywordArguments;
            }

            // Getters for functionName, arguments, and keywordArguments

        public J_JinjaIdentifier getFunctionName() {
            return functionName;
        }

        public List<J_JinjaExpression> getArguments() {
            return arguments;
        }

        public List<J_JinjaKeywordArgument> getKeywordArguments() {
            return keywordArguments;
        }

        @Override
        public <T> T accept(AstVisitor<T> visitor) {
            return visitor.visitJinjaFunctionCall(this);
            // Getters for functionName, arguments, and keywordArguments
        }


        }





