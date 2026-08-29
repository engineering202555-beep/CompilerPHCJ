package python.ASTpy;

import java.util.ArrayList;
import java.util.List;

// render_template("index.html", user=u)
public class PYCallExprNode extends PYExpressionNode{

    private PYExpressionNode callee;
    private List<PYArgumentNode> arguments;

    public PYCallExprNode(int line, PYExpressionNode name) {
        super(line, "FunctionCallNode");
        this.callee = name;
        this.arguments = new ArrayList<>();
    }

    public void addArgument(PYArgumentNode arg) {
        if (arg != null) {
            this.arguments.add(arg);
        }
    }

    public void setCallee(PYExpressionNode functionName) {
        this.callee = functionName;
    }

    public PYExpressionNode getCallee() { return callee; }
    public List<PYArgumentNode> getArguments() { return arguments; }

    @Override
    public void printDetailed(String prefix, boolean isLast) {
        System.out.println(prefix + (isLast ? "└── " : "├── ") + getNodeName()  + " (Line: " + getLine() + ")");

        String childPrefix = prefix + (isLast ? "    " : "│   ");

        System.out.println(childPrefix + "└── callee:");
        callee.printDetailed(childPrefix + "    ", true);

        if (!arguments.isEmpty()) {
            System.out.println(childPrefix + "└── arguments:");
            for (int i = 0; i < arguments.size(); i++) {
                boolean lastArg = (i == arguments.size() - 1);
                arguments.get(i).printDetailed(childPrefix + "    ", lastArg);
            }
        }
    }

    @Override
    public void printASTStructure(String prefix, boolean isLast) {
        System.out.println(prefix + (isLast ? "└── " : "├── ")
                + getClass().getSimpleName() + " (Line: " + getLine() + ")");

        String childPrefix = prefix + (isLast ? "    " : "│   ");

        callee.printASTStructure(childPrefix, arguments.isEmpty());

        for (int i = 0; i < arguments.size(); i++) {
            boolean lastArg = (i == arguments.size() - 1);
            arguments.get(i).printASTStructure(childPrefix, lastArg);
        }
    }

}
