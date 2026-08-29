package python.SymbolTable;

public class Symbol {

    public enum SymbolKind {
        VARIABLE,
        FUNCTION,
        PARAMETER,
        IMPORT,
        ITERATOR
    }

    public enum ScopeType {
        GLOBAL, LOCAL
    }

    private String name;
    private SymbolKind type;       // (VARIABLE, FUNCTION, PARAMETER, IMPORT, ITERATOR)
    private ScopeType scope;   // (GLOBAL, LOCAL)
    private int lineNumber;
    private String value;      // اختيارياً: لتخزين القيمة الأولية إن وجدت


    public Symbol(String name, SymbolKind type, ScopeType scope, int lineNumber, String value) {
        this.name = name;
        this.type = type;
        this.scope = scope;
        this.lineNumber = lineNumber;
        this.value = value;
    }

    // Getters
    public String getName() { return name; }
    public SymbolKind getType() { return type; }
    public ScopeType getScope() { return scope; }
    public int getLineNumber() { return lineNumber; }
    public String getValue() { return value; }

    @Override
    public String toString() {
        return String.format("| %-15s | %-12s | %-8s | %-6d |", name, type, scope, lineNumber);
    }
}