package python.ASTpy;

import java.util.ArrayList;
import java.util.List;

public class PYIfNode extends PYStatementNode {

    private PYExpressionNode ifCondition;
    private PYBlockSuiteNode ifBody;

    private List<PYExpressionNode> elifConditions;
    private List<PYBlockSuiteNode> elifBodies;

    private PYBlockSuiteNode elseBody;

    public PYIfNode(int line, PYExpressionNode ifCondition) {
        super(line, "IfStatementNode");
        this.ifCondition = ifCondition;
        this.elifConditions = new ArrayList<>();
        this.elifBodies = new ArrayList<>();
    }

    public void setIfBody(PYBlockSuiteNode ifBody) {
        this.ifBody = ifBody;
    }

    public void addElif(PYExpressionNode condition, PYBlockSuiteNode body) {
        this.elifConditions.add(condition);
        this.elifBodies.add(body);
    }

    public void setElseBody(PYBlockSuiteNode elseBody) {
        this.elseBody = elseBody;
    }

    @Override
    public void printDetailed(String prefix, boolean isLast) {
        System.out.println(prefix + (isLast ? "└── " : "├── ") + getNodeName()  + " (Line: " + getLine() + ")");

        String childPrefix = prefix + (isLast ? "    " : "│   ");

        // if
        if (ifCondition != null) {
            System.out.println(childPrefix + "├── condition:");
            ifCondition.printDetailed(childPrefix + "│   ", false);
        }
        if (ifBody != null) {
            System.out.println(childPrefix + "└── body:");
            ifBody.printDetailed(childPrefix + "    ", true);
        }

        // elifs
        for (int i = 0; i < elifConditions.size(); i++) {
            PYExpressionNode cond = elifConditions.get(i);
            PYBlockSuiteNode body = elifBodies.get(i);

            System.out.println(childPrefix + "├── elif condition:");
            cond.printDetailed(childPrefix + "│   ", false);

            System.out.println(childPrefix + "└── elif body:");
            body.printDetailed(childPrefix + "    ", true);
        }

        // else
        if (elseBody != null) {
            System.out.println(childPrefix + "└── else body:");
            elseBody.printDetailed(childPrefix + "    ", true);
        }
    }

    @Override
    public void printASTStructure(String prefix, boolean isLast) {
        System.out.println(prefix + (isLast ? "└── " : "├── ") + getClass().getSimpleName() + " (Line: " + getLine() + ")");

        String childPrefix = prefix + (isLast ? "    " : "│   ");

        if (ifCondition != null)
            ifCondition.printASTStructure(childPrefix, false);
        if (ifBody != null)
            ifBody.printASTStructure(childPrefix, elifConditions.isEmpty() && elseBody == null);

        for (int i = 0; i < elifConditions.size(); i++) {
            PYExpressionNode cond = elifConditions.get(i);
            PYBlockSuiteNode body = elifBodies.get(i);

            cond.printASTStructure(childPrefix, false);
            body.printASTStructure(childPrefix, i == elifConditions.size() - 1 && elseBody == null);
        }

        if (elseBody != null)
            elseBody.printASTStructure(childPrefix, true);
    }

    public PYExpressionNode getIfCondition() { return ifCondition; }
    public PYBlockSuiteNode getIfBody() { return ifBody; }
    public List<PYExpressionNode> getElifConditions() { return elifConditions; }
    public List<PYBlockSuiteNode> getElifBodies() { return elifBodies; }
    public PYBlockSuiteNode getElseBody() { return elseBody; }

}