package python.ASTpy;

import java.util.ArrayList;
import java.util.List;

//////هذه عقدة وسيطة , عقدة تجميع
public class PYDecoratorsNode extends PYASTNode {

    private List<PYDecoratorNode> decorators;

    public PYDecoratorsNode(int line) {
        super(line, "DecoratorsNode");
        this.decorators = new ArrayList<>();
    }

    public void addDecorator(PYDecoratorNode decorator) {
        decorators.add(decorator);
    }

    public List<PYDecoratorNode> getDecorators() {
        return decorators;
    }

    @Override
    public void printDetailed(String prefix, boolean isLast) {
        System.out.println(prefix + (isLast ? "└── " : "├── ") + getNodeName() + " (Line: " + getLine() + ")" );
        String childPrefix = prefix + (isLast ? "    " : "│   ");
        for (int i = 0; i < decorators.size(); i++) {
            decorators.get(i).printDetailed(childPrefix, i == decorators.size() - 1);
        }
    }

    @Override
    public void printASTStructure(String prefix, boolean isLast) {
        System.out.println(prefix + (isLast ? "└── " : "├── ")
                + getClass().getSimpleName() + " (Line: " + getLine() + ")");
        String childPrefix = prefix + (isLast ? "    " : "│   ");
        for (int i = 0; i < decorators.size(); i++) {
            decorators.get(i).printASTStructure(childPrefix, i == decorators.size() - 1);
        }
    }

}
