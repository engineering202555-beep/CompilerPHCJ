package SymbolTableHCJ;


public class Symbol {

    public enum SymbolKind {
        // ===== HTML =====
        HTML_ELEMENT,
        HTML_ATTRIBUTE,

        // ===== CSS =====
        CSS_SELECTOR,
        CSS_PROPERTY,

        // ===== JINJA =====
        JINJA_VARIABLE,
        JINJA_FUNCTION,
        JINJA_PARAMETER,
        JINJA_ITERATOR,
        JINJA_DIRECTIVE,   // for

        // ===== GENERAL =====
        TEMPLATE,
    }

    public enum ScopeType {
        GLOBAL,
        HTML,
        CSS,
        JINJA
    }

    private String name;
    private SymbolKind type;
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