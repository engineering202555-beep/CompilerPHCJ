package python.ASTpy;

import java.util.ArrayList;
import java.util.List;

public class PYDictNode extends PYExpressionNode {

    private List<PYKeyValueNode> entries;

    public PYDictNode(int line) {
        super(line, "DictionaryNode");
        this.entries = new ArrayList<>();
    }

    public void addEntry(PYKeyValueNode entry) {
        this.entries.add(entry);
    }

    // إضافة ضرورية: لا وجود لأي getter سابقاً لقائمة entries، مما كان يمنع
    // FlaskContextExtractor من قراءة محتوى أي dict literal في بايثون
    public List<PYKeyValueNode> getEntries() {
        return this.entries;
    }

    @Override
    public void printDetailed(String prefix, boolean isLast) {
        System.out.println(prefix + (isLast ? "└── " : "├── ") + getNodeName()  + " (Line: " + getLine() + ")");

        String childPrefix = prefix + (isLast ? "    " : "│   ");

        if (!entries.isEmpty()) {
            System.out.println(childPrefix + "└── entries:");
            for (int i = 0; i < entries.size(); i++) {
                boolean lastEntry = (i == entries.size() - 1);
                entries.get(i).printDetailed(childPrefix + "    ", lastEntry);
            }
        }
    }

    @Override
    public void printASTStructure(String prefix, boolean isLast) {
        System.out.println(prefix + (isLast ? "└── " : "├── ") +
                getClass().getSimpleName() + " (Line: " + getLine() + ")");

        String childPrefix = prefix + (isLast ? "    " : "│   ");

        for (int i = 0; i < entries.size(); i++) {
            boolean lastEntry = (i == entries.size() - 1);
            entries.get(i).printASTStructure(childPrefix, lastEntry);
        }
    }


}