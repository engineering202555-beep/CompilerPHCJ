package python.ASTpy;

import java.util.ArrayList;
import java.util.List;


public class PYProgramNode extends PYASTNode{

    private List<PYStatementNode> statements ;

    public PYProgramNode(int line) {
        super(line, "ProgramNode");
        this.statements = new ArrayList<>();
    }

    public void addStatement(PYStatementNode stmt) {
        if (stmt != null) {
            this.statements.add(stmt);
        }
    }

    public List<PYStatementNode> getStatements() {
        return statements;
    }

    /////////////////////////////
    @Override
    public void printDetailed(String prefix, boolean isLast) {
        System.out.println(prefix + (isLast ? "└── " : "├── ")
                + getClass().getSimpleName() + " (Line: " + getLine() + ")");

        String childPrefix = prefix + (isLast ? "    " : "│   ");

        for (int i = 0; i < statements.size(); i++) {
            statements.get(i).printDetailed(
                    childPrefix,
                    i == statements.size() - 1
            );
        }
    }

    @Override
    public void printASTStructure(String prefix, boolean isLast) {
        System.out.println(prefix + (isLast ? "└── " : "├── ")
                + getClass().getSimpleName()
                + " (Line: " + getLine() + ")");

        String childPrefix = prefix + (isLast ? "    " : "│   ");

        for (int i = 0; i < statements.size(); i++) {
            statements.get(i).printASTStructure(
                    childPrefix,
                    i == statements.size() - 1
            );
        }
    }

}
