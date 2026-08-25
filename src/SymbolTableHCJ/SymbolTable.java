/*package SymbolTableHCJ;

import java.util.*;

public class SymbolTable {

    private Map<String, Symbol> symbols = new LinkedHashMap<>();
    private Stack<Symbol.ScopeType> scopeStack = new Stack<>();

    public SymbolTable() {
        scopeStack.push(Symbol.ScopeType.GLOBAL);
    }

    public void addSymbol(String name,
                          Symbol.SymbolKind type,
                          int line,
                          String value) {

        String uniqueKey = name + "@" + line;

        Symbol symbol = new Symbol(
                name,
                type,
                scopeStack.peek(),
                line,
                value
        );

        symbols.put(uniqueKey, symbol);
    }

    public Symbol lookup(String name) {

        Symbol found = null;

        for (Symbol s : symbols.values()) {
            if (s.getName().equals(name)) {
                found = s;
            }
        }

        return found;
    }

    public void pushScope(Symbol.ScopeType scope) {
        scopeStack.push(scope);
    }

    public void popScope() {
        if (scopeStack.size() > 1) {
            scopeStack.pop();
        }
    }

    public void printTable() {

        System.out.println("\n=== DETAILED SYMBOL TABLE ===");

        String header =
                "+-----------------+--------------+----------+--------+--------------------------------+";

        System.out.println(header);

        System.out.printf(
                "| %-15s | %-12s | %-8s | %-6s | %-30s |%n",
                "Name",
                "Type",
                "Scope",
                "Line",
                "Value/Expression"
        );

        System.out.println(header);

        for (Symbol s : symbols.values()) {

            System.out.printf(
                    "| %-15s | %-12s | %-8s | %-6d | %-30s |%n",
                    s.getName(),
                    s.getType(),
                    s.getScope(),
                    s.getLineNumber(),
                    s.getValue() == null ? "None" : s.getValue()
            );
        }

        System.out.println(header);
    }
}*/
package SymbolTableHCJ;

import java.util.*;

public class SymbolTable {

    // الخريطة المحلية لهذا النطاق فقط (المفتاح هو الاسم فقط)
    private Map<String, Symbol> localSymbols = new HashMap<>();

    // مؤشر للنطاق الأب (لحل مشكلة الـ Scoping والبحث التصاعدي)
    private SymbolTable parent;

    // قائمة عامة تجمع كل الرموز في البرنامج بأكمله (فقط لغرض الطباعة النهائية بنجاح)
    private static List<Symbol> allSymbolsForPrinting = new ArrayList<>();

    private Symbol.ScopeType scopeType;

    // الـ Constructor للنطاق العام (Global)
    public SymbolTable() {
        this.parent = null;
        this.scopeType = Symbol.ScopeType.GLOBAL;
    }

    // الـ Constructor لإنشاء نطاق فرعي (مثل داخل الـ For loop أو If block)
    public SymbolTable(SymbolTable parent, Symbol.ScopeType scopeType) {
        this.parent = parent;
        this.scopeType = scopeType;
    }

    // إضافة رمز للنطاق الحالي
    public void addSymbol(String name, Symbol.SymbolKind type, int line, String value) {
        Symbol symbol = new Symbol(name, type, this.scopeType, line, value);

        // يُحفظ محلياً باسمه فقط لسهولة الاستدعاء
        localSymbols.put(name, symbol);

        // يُحفظ في القائمة العامة للطباعة لاحقاً
        allSymbolsForPrinting.add(symbol);
    }

    // دالة البحث التصاعدي (مهمة جداً لـ Undefined Variable و Scope Error)
    public Symbol lookup(String name) {
        // 1. ابحث في النطاق الحالي أولاً
        if (localSymbols.containsKey(name)) {
            return localSymbols.get(name);
        }

        // 2. إذا لم تجده، ابحث في النطاق الأب (وهكذا صعوداً حتى الـ Global)
        if (parent != null) {
            return parent.lookup(name);
        }

        // 3. غير موجود مطلقاً (Undefined)
        return null;
    }
    public static List<Symbol> getAllSymbols() {
        return new ArrayList<>(allSymbolsForPrinting);
    }

    public static void clearSymbols() {
        allSymbolsForPrinting.clear();
    }
    // الحصول على النطاق الأب عند الخروج من البلوك (بديل الـ popScope)
    public SymbolTable getParent() {
        return this.parent;
    }

    public Symbol.ScopeType getScopeType() {
        return this.scopeType;
    }

    // طباعة الجدول الشامل لجميع الرموز التي تم رصدها
    public static void printAllSymbols() {
        System.out.println("\n=== DETAILED HTML/JINJA SYMBOL TABLE ===");
        String header = "+-----------------+--------------+----------+--------+--------------------------------+";
        System.out.println(header);
        System.out.printf("| %-15s | %-12s | %-8s | %-6s | %-30s |\n", "Name", "Type", "Scope", "Line", "Value/Expression");
        System.out.println(header);

        for (Symbol s : allSymbolsForPrinting) {
            System.out.printf("| %-15s | %-12s | %-8s | %-6d | %-30s |\n",
                    s.getName(), s.getType(), s.getScope(), s.getLineNumber(),
                    (s.getValue() == null ? "None" : s.getValue()));
        }
        System.out.println(header);
    }
}