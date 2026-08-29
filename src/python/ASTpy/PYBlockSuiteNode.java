package python.ASTpy;

import java.util.ArrayList;
import java.util.List;

public class PYBlockSuiteNode extends PYStatementNode {

    private List<PYStatementNode> statements ;

    public PYBlockSuiteNode(int line) {
        super(line, "BlockNode");
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

    @Override
    public void printDetailed(String prefix, boolean isLast) {
        System.out.println(prefix + (isLast ? "└── " : "├── ") + getNodeName()  + " (Line: " + getLine() + ")");
        String childPrefix = prefix + (isLast ? "    " : "│   ");
        for (int i = 0; i < statements.size(); i++) {
            boolean lastStmt = (i == statements.size() - 1);
            statements.get(i).printDetailed(childPrefix, lastStmt);
        }
    }

    @Override
    public void printASTStructure(String prefix, boolean isLast) {
        System.out.println(prefix + (isLast ? "└── " : "├── ")
                + getClass().getSimpleName() + " (Line: " + getLine() + ")");
        String childPrefix = prefix + (isLast ? "    " : "│   ");
        for (int i = 0; i < statements.size(); i++) {
            boolean lastStmt = (i == statements.size() - 1);
            statements.get(i).printASTStructure(childPrefix, lastStmt);
        }
    }

}
