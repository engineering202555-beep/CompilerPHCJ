package ASTHCJ;

public abstract class HtmlAttribute extends AstNode {

    protected final String name;

    protected HtmlAttribute(String name, int lineNumber) {
        super("HtmlAttribute", lineNumber);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 💡 أضيفي هذا التابع هنا: يعيد null افتراضياً للخصائص التي بلا قيمة (مثل required)
    public AstNode getValue() {
        return null;
    }

    @Override
    public String toString() {
        return "HtmlAttribute{" +
                "name='" + name + '\'' +
                '}';
    }
}