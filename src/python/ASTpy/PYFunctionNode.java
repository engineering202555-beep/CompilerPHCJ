package python.ASTpy;

import java.util.ArrayList;
import java.util.List;

public class PYFunctionNode extends PYStatementNode{

    private String functionName;
    private List<PYIdentifierNode> parameters;
    private PYBlockSuiteNode body;
    private List<PYDecoratorNode> decorators;

    public PYFunctionNode(int line, String functionName) {
        super(line, "FunctionNode: " + functionName);
        this.functionName = functionName;
        this.parameters = new ArrayList<>();
        this.decorators = new ArrayList<>();
    }

    public void setBody(PYBlockSuiteNode body) {
        this.body = body;
    }

    public void addDecorator(PYDecoratorNode decorator) {
        this.decorators.add(decorator);
    }

    public void addParameter(PYIdentifierNode param) {
        this.parameters.add(param);
    }


    @Override
    public void printDetailed(String prefix, boolean isLast) {
        System.out.println(prefix + (isLast ? "└── " : "├── ") + "FunctionNode: " + functionName  + " (Line: " + getLine() + ")");

        // decorators
        for (int i = 0; i < decorators.size(); i++) {
            boolean lastDec = (i == decorators.size() - 1 && body == null && parameters.isEmpty());
            decorators.get(i).printDetailed(prefix + (isLast ? "    " : "│   "), lastDec);
        }

        // parameters
        if (!parameters.isEmpty()) {
            System.out.println(prefix + (isLast ? "    " : "│   ") + "├── Parameters:");
            for (int i = 0; i < parameters.size(); i++) {
                boolean lastParam = (i == parameters.size() - 1);
                parameters.get(i).printDetailed(prefix + (isLast ? "    " : "│   ") + (lastParam ? "    " : "│   "), lastParam);
            }
        }

        // body
        if (body != null) {
            body.printDetailed(prefix + (isLast ? "    " : "│   "), true);
        }
    }

    @Override
    public void printASTStructure(String prefix, boolean isLast) {
        System.out.println(prefix + (isLast ? "└── " : "├── ") + getClass().getSimpleName() +
                " (Line: " + getLine() + ")");

        // decorators
        for (int i = 0; i < decorators.size(); i++) {
            boolean lastDec = (i == decorators.size() - 1 && body == null && parameters.isEmpty());
            decorators.get(i).printASTStructure(prefix + (isLast ? "    " : "│   "), lastDec);
        }

        // parameters
        if (!parameters.isEmpty()) {
            System.out.println(prefix + (isLast ? "    " : "│   ") + "├── Parameters:");
            for (int i = 0; i < parameters.size(); i++) {
                boolean lastParam = (i == parameters.size() - 1);
                parameters.get(i).printASTStructure(prefix + (isLast ? "    " : "│   ") + (lastParam ? "    " : "│   "), lastParam);
            }
        }

        // body
        if (body != null) {
            body.printASTStructure(prefix + (isLast ? "    " : "│   "), true);
        }
    }

    public String getFunctionName() { return functionName; }
    public List<PYIdentifierNode> getParameters() { return parameters; }
    public PYBlockSuiteNode getBody() { return body; }
    public List<PYDecoratorNode> getDecorators() {return decorators;}
}
