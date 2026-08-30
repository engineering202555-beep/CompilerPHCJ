package python.SemanticPY;

import java.util.HashMap;
import java.util.Map;

/**
 * جدول نطاقات متداخل (parent-chain) خاص حصراً بالتحليل الدلالي لبايثون.
 *
 * ملاحظات تصميم مهمة:
 * - هذا الكلاس منفصل تماماً عن python.SymbolTable.SymbolTable ولا يعدّلها ولا يعتمد عليها،
 *   بناءً على طلب صريح بعدم لمس تلك الحزمة.
 * - نطاق جديد (PythonScope فرعي) يُفتح فقط عند دخول جسم دالة (function body).
 *   لا يُفتح نطاق جديد عند {@code for} أو {@code if}، لأن بايثون فعلياً لا تفتح
 *   نطاقاً جديداً لهذه الجمل (خلافاً لـ HTML/CSS في SymbolTableHCJ حيث كل tag/rule
 *   يفتح نطاقاً فرعياً). هذا قرار تصميمي واعٍ ويعكس سلوك بايثون الحقيقي، وليس خطأ.
 */
public class PythonScope {

    public enum SymbolKind {
        VARIABLE,
        PARAMETER,
        FUNCTION,
        IMPORT,
        ITERATOR
    }

    public static class PythonSymbol {
        private final String name;
        private final SymbolKind kind;
        private final int line;
        // صحيح فقط إذا كانت هذه القيمة نتيجة إسناد مباشر لقيمة حرفية (literal)
        // (رقم/نص/قائمة/قاموس)، تُستخدم فقط في فحص Type Error المحدود (استدعاء
        // متغير غير قابل للاستدعاء كأنه دالة).
        private final boolean literalValue;

        public PythonSymbol(String name, SymbolKind kind, int line, boolean literalValue) {
            this.name = name;
            this.kind = kind;
            this.line = line;
            this.literalValue = literalValue;
        }

        public String getName() { return name; }
        public SymbolKind getKind() { return kind; }
        public int getLine() { return line; }
        public boolean isLiteralValue() { return literalValue; }
    }

    private final Map<String, PythonSymbol> localSymbols = new HashMap<>();
    private final PythonScope parent;
    private final String scopeName;

    /** إنشاء النطاق العام (Global) - بدون أب. */
    public PythonScope() {
        this.parent = null;
        this.scopeName = "global";
    }

    /** إنشاء نطاق فرعي (حالياً: نطاق دالة فقط) مرتبط بنطاق أب. */
    public PythonScope(PythonScope parent, String scopeName) {
        this.parent = parent;
        this.scopeName = scopeName;
    }

    public void declare(String name, SymbolKind kind, int line, boolean literalValue) {
        localSymbols.put(name, new PythonSymbol(name, kind, line, literalValue));
    }

    /** بحث تصاعدي في سلسلة النطاقات الأب، بنفس نمط SymbolTableHCJ.lookup(). */
    public PythonSymbol resolve(String name) {
        if (localSymbols.containsKey(name)) {
            return localSymbols.get(name);
        }
        if (parent != null) {
            return parent.resolve(name);
        }
        return null;
    }

    public boolean isDeclaredLocally(String name) {
        return localSymbols.containsKey(name);
    }

    public PythonScope getParent() { return parent; }
    public String getScopeName() { return scopeName; }
}