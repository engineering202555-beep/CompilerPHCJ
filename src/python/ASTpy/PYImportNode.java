package python.ASTpy;

import java.util.ArrayList;
import java.util.List;

public class PYImportNode extends PYStatementNode{

    private PYIdentifierNode moduleName;           // اسم المكتبة (مثل flask)
    private List<PYIdentifierNode> importedItems;  // العناصر المستوردة (مثل render_template, request)
    private boolean isFromImport;        // هل هي صيغة 'from x import y' أم 'import x'

    // Constructor لصيغة from flask import render_template, ...
    public PYImportNode(int line, PYIdentifierNode moduleName , List<PYIdentifierNode> importedItems ) {
        super(line, "ImportNode");
        this.moduleName = moduleName;
        this.importedItems = importedItems;
        this.isFromImport = true;
    }

    // Constructor لصيغة import os (اختياري لدعم بايثون بشكل عام)
    public PYImportNode(int line, PYIdentifierNode moduleName) {
        super(line, "ImportNode");
        this.moduleName = moduleName;
        this.importedItems = new ArrayList<>();
        this.isFromImport = false;
    }

    public void addItem(PYIdentifierNode item) {
        this.importedItems.add(item);
    }

    @Override
    public void printDetailed(String prefix, boolean isLast) {
        System.out.println(prefix + (isLast ? "└── " : "├── ") + "ImportNode"  + " (Line: " + getLine() + ")");

        String childPrefix = prefix + (isLast ? "    " : "│   ");

        // module
        System.out.println(childPrefix + "├── module:");
        moduleName.printDetailed(childPrefix + "│   ", true);

        // imported items (only if from import)
        if (isFromImport && !importedItems.isEmpty()) {
            System.out.println(childPrefix + "└── importedItems:");
            for (int i = 0; i < importedItems.size(); i++) {
                importedItems.get(i).printDetailed(
                        childPrefix + "    ",
                        i == importedItems.size() - 1
                );
            }
        }
    }

    @Override
    public void printASTStructure(String prefix, boolean isLast) {
        System.out.println(
                prefix + (isLast ? "└── " : "├── ")
                        + getClass().getSimpleName()
                        + " (Line: " + getLine() + ")"
        );

        String childPrefix = prefix + (isLast ? "    " : "│   ");

        // module
        moduleName.printASTStructure(childPrefix, importedItems.isEmpty());

        // imported identifiers
        for (int i = 0; i < importedItems.size(); i++) {
            importedItems.get(i).printASTStructure(
                    childPrefix,
                    i == importedItems.size() - 1
            );
        }
    }

    public PYIdentifierNode getModuleName() { return moduleName; }
    public List<PYIdentifierNode> getImportedItems() { return importedItems; }
    public boolean isFromImport() { return isFromImport; }

}
