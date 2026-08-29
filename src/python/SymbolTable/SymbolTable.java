package python.SymbolTable;

import java.util.*;

public class SymbolTable {
    // المفتاح هنا هو String يجمع (الاسم + رقم السطر) لضمان التتبع الدقيق
    private Map<String, Symbol> symbols = new LinkedHashMap<>();
    private Stack<Symbol.ScopeType> scopeStack = new Stack<>();

    public SymbolTable() {
        scopeStack.push(Symbol.ScopeType.GLOBAL);
    }

    public void addSymbol(String name, Symbol.SymbolKind type, int line, String value) {
        String uniqueKey = name + "@" + line;
        Symbol symbol = new Symbol(name, type, scopeStack.peek(), line, value);
        symbols.put(uniqueKey, symbol);
    }

    public Symbol lookup(String name) {
        Symbol found = null;

        for (Symbol s : symbols.values()) {
            if (s.getName().equals(name)) {
                found = s; // نخزن آخر تعريف (الأقرب زمنيًا)
            }
        }

        return found;
    }


    public void pushScope(Symbol.ScopeType scope) { scopeStack.push(scope); }
    public void popScope() { if (scopeStack.size() > 1) scopeStack.pop(); }

    public void printTable() {
        System.out.println("\n=== DETAILED PYTHON SYMBOL TABLE ===");
        String header = "+-----------------+--------------+----------+--------+--------------------------------+";
        System.out.println(header);
        System.out.printf("| %-15s | %-12s | %-8s | %-6s | %-30s |\n", "Name", "Type", "Scope", "Line", "Value/Expression");
        System.out.println(header);

        for (Symbol s : symbols.values()) {
            System.out.printf("| %-15s | %-12s | %-8s | %-6d | %-30s |\n",
                    s.getName(), s.getType(), s.getScope(), s.getLineNumber(),
                    (s.getValue() == null ? "None" : s.getValue()));
        }
        System.out.println(header);
    }
}
