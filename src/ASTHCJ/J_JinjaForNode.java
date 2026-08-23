package ASTHCJ;

import VisitorHCJ.AstVisitor;
import java.util.List;

public class J_JinjaForNode extends J_JinjaStatement {

    private final List<J_JinjaLoopVariable> variable;
    private final J_JinjaExpression iterable;
    private List<AstNode> body;

    public J_JinjaForNode(
            List<J_JinjaLoopVariable> variable,
            J_JinjaExpression iterable,
            List<AstNode> body,
            int lineNumber
    ) {
        super("JinjaForNode", lineNumber);
        this.variable = variable;
        this.iterable = iterable;
        this.body = body;
    }

    public List<J_JinjaLoopVariable> getVariable() {
        return variable;
    }

    public J_JinjaExpression getIterable() {
        return iterable;
    }

    public List<AstNode> getBody() {
        return body;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visitJinjaForNode(this);
    }
    public void setBody(List<AstNode>body){
        this.body=body;
}  }




