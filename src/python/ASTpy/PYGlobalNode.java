package python.ASTpy;

import java.util.ArrayList;
import java.util.List;

public class PYGlobalNode extends PYStatementNode {

    private List<PYIdentifierNode> variableNames; // قائمة بأسماء المتغيرات المصرح عنها كـ global

    public PYGlobalNode(int line) {
        super(line, "GlobalDeclarationNode");
        this.variableNames = new ArrayList<>();
    }

    public void addVariable(PYIdentifierNode name) {
        this.variableNames.add(name);
    }

    public List<PYIdentifierNode> getVariableNames() {
        return variableNames;
    }

    @Override
    public void printDetailed(String prefix, boolean isLast) {
        System.out.println(prefix + (isLast ? "└── " : "├── ") + "GlobalDeclaration"  + " (Line: " + getLine() + ")");

        for (int i = 0; i < variableNames.size(); i++) {
            boolean lastVar = (i == variableNames.size() - 1);
            variableNames.get(i).printDetailed(prefix + (isLast ? "    " : "│   "), lastVar);
        }
    }

    @Override
    public void printASTStructure(String prefix, boolean isLast) {
        System.out.println(prefix + (isLast ? "└── " : "├── ") + getClass().getSimpleName() +
                " (Line: " + getLine() + ")");

        for (int i = 0; i < variableNames.size(); i++) {
            boolean lastVar = (i == variableNames.size() - 1);
            variableNames.get(i).printASTStructure(prefix + (isLast ? "    " : "│   "), lastVar);
        }
    }

}
