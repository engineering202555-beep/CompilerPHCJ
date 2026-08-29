package python.ASTpy;

import java.util.ArrayList;
import java.util.List;

public class PYDecoratorNode extends PYASTNode{

    private PYExpressionNode  callee; // مثل app.route
    private List<PYArgumentNode> arguments;   //مثلاً "/", methods=...)

    public PYDecoratorNode(int line, PYExpressionNode  callee) {
        super(line, "DecoratorNode");
        this.callee = callee;
        this.arguments = new ArrayList<>();
    }

    public void addArgument(PYArgumentNode arg) {
        this.arguments.add(arg);
    }

    @Override
    public void printDetailed(String prefix, boolean isLast) {
        System.out.println(prefix + (isLast ? "└── " : "├── ") + getNodeName() + " (Line: " + getLine() + ")");

        String childPrefix = prefix + (isLast ? "    " : "│   ");
        System.out.println(childPrefix + "└── name:");
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
    public PYExpressionNode getCallee() { return callee; }
    public List<PYArgumentNode> getArguments() { return arguments; }

}
