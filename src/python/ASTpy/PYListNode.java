package python.ASTpy;

import java.util.ArrayList;
import java.util.List;

public class PYListNode extends PYExpressionNode{

    private List<PYExpressionNode> elements;

    public PYListNode(int line) {
        super(line, "ListNode");
        this.elements = new ArrayList<>();
    }

    public void addElement(PYExpressionNode element) {
        if (element != null) {
            this.elements.add(element);
        }
    }

    public List<PYExpressionNode> getElements() {
        return elements;
    }

    @Override
    public void printDetailed(String prefix, boolean isLast) {
        System.out.println(prefix + (isLast ? "└── " : "├── ") + getNodeName() + " (Line: " + getLine() + ")");

        String childPrefix = prefix + (isLast ? "    " : "│   ");

        if (!elements.isEmpty()) {
            System.out.println(childPrefix + "└── elements:");
            for (int i = 0; i < elements.size(); i++) {
                boolean lastElem = (i == elements.size() - 1);
                elements.get(i).printDetailed(childPrefix + "    ", lastElem);
            }
        }
    }

    @Override
    public void printASTStructure(String prefix, boolean isLast) {
        System.out.println(prefix + (isLast ? "└── " : "├── ") +
                getClass().getSimpleName() + " (Line: " + getLine() + ")");

        String childPrefix = prefix + (isLast ? "    " : "│   ");

        for (int i = 0; i < elements.size(); i++) {
            boolean lastElem = (i == elements.size() - 1);
            elements.get(i).printASTStructure(childPrefix, lastElem);
        }
    }

}
