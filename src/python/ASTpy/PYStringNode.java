package python.ASTpy;

public class PYStringNode extends PYLiteralNode{

    private String value;

    public PYStringNode(int line, String val) {
        super(line, "StringNode");
        if (val != null && val.length() >= 2) {
            if ((val.startsWith("\"") && val.endsWith("\"")) ||
                    (val.startsWith("'") && val.endsWith("'"))) {

                this.value = val.substring(1, val.length() - 1);
                return;
            }
        }

        this.value = val;
    }

    // إضافة ضرورية: لا وجود لأي getter سابقاً - كانت تمنع قراءة نص الـ route
    // الحقيقي من @app.route("...") عند استخراج الـ routes من الـ decorators
    public String getValue() {
        return this.value;
    }

    @Override
    public void printDetailed(String prefix, boolean isLast) {
        System.out.println(prefix + (isLast ? "└── " : "├── ") + getNodeName() + "(\"" + value + "\")"  + " (Line: " + getLine() + ")");
    }

    @Override
    public void printASTStructure(String prefix, boolean isLast) {
        System.out.println(prefix + (isLast ? "└── " : "├── ")
                + getClass().getSimpleName() + " (Line: " + getLine() + ")");
    }

}