//package python.VisitorPY;
//
//import python.ASTpy.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class FlaskContextExtractor {
//
//    // القائمة التي ستخزن المتغيرات المكتشفة
//    private final List<String> extractedVariables = new ArrayList<>();
//    // القائمة التي ستخزن الدوال المكتشفة
//    private final List<String> extractedFunctions = new ArrayList<>();
//
//    public List<String> getExtractedVariables() {
//        return extractedVariables;
//    }
//    public List<String> getExtractedFunctions() {
//        return this.extractedFunctions;
//    }
//    // 🚀 دالة الفحص الاستقرائي (Recursive Extraction)
//    // هذه الدالة ستمر على كل عقدة في الشجرة وتبحث عن render_template
//    public void extract(PYASTNode node) {
//        if (node == null) return;
//
//        // ==========================================
//        // 1. هدفنا: اصطياد استدعاءات الدوال
//        // ==========================================
//        if (node instanceof PYCallExprNode callNode) {
//
//            // التأكد من أن الدالة المستدعاة هي render_template
//            if (callNode.getCallee() instanceof PYIdentifierNode idNode) {
//
//                // ⚠️ ملاحظة: إذا كان التابع لديك لطباعة اسم المعرف مختلفاً (مثل getValue أو getText)، قم بتغيير getName() أدناه
//                // ولكن غالباً في الـ IdentifierNode يكون التابع getName() أو getValue()
//                if ("render_template".equals(idNode.getName())) {
//
//                    // البحث داخل المعاملات (Arguments) عن الـ Keyword Arguments
//                    if (callNode.getArguments() != null) {
//                        for (PYArgumentNode arg : callNode.getArguments()) {
//
//                            // اصطياد المعاملات التي تأتي بصيغة (key=value) مثل products=products
//                            if (arg instanceof PYKeyWordArgNode kwArg) {
//
//                                if (kwArg.getKey() instanceof PYIdentifierNode keyId) {
//                                    // تخزين اسم المتغير في القائمة!
//                                    extractedVariables.add(keyId.getName());
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//        // ==========================================
//        // 2. تتبع الأبناء (المرور على بقية الشجرة)
//        // ==========================================
//        if (node instanceof PYProgramNode progNode) {
//            if (progNode.getStatements() != null) {
//                for (PYStatementNode stmt : progNode.getStatements()) {
//                    extract(stmt);
//                }
//            }
//        }
//        else if (node instanceof PYBlockSuiteNode blockNode) {
//            if (blockNode.getStatements() != null) {
//                for (PYStatementNode stmt : blockNode.getStatements()) {
//                    extract(stmt);
//                }
//            }
//        }
//        else if (node instanceof PYFunctionNode funcNode) {
//            extract(funcNode.getBody());
//        }
//        else if (node instanceof PYForNode forNode) {
//            extract(forNode.getBody());
//        }
//        else if (node instanceof PYIfNode ifNode) {
//            extract(ifNode.getIfBody());
//            if (ifNode.getElseBody() != null) extract(ifNode.getElseBody());
//            // ملاحظة: يمكنك إضافة تتبع الـ elif هنا إذا رغبت
//        }
//        else if (node instanceof PYExprStmtNode exprStmt) {
//            extract(exprStmt.getExpression());
//        }
//        else if (node instanceof PYAssignmentNode assignNode) {
//            extract(assignNode.getValue());
//        }
//        // 🔥 التعديل السحري والنهائي لحل مشكلة المصفوفة الفارغة 🔥
//        else if (node instanceof PYReturnNode returnNode) {
//            // تتبع القيمة البرمجية الموجودة بعد كلمة return (مثل استدعاء render_template)
//            // ⚠️ تنبيه: إذا ظهر خطأ باللون الأحمر تحت getReturnValue()،
//            // تأكد من اسم الدالة (الـ Getter) داخل كلاس PYReturnNode لديك، فقد تكون getExpression() أو getExpr()
//            extract(returnNode.getValue());
//        }
//    }
//}


//package python.VisitorPY;
//
//import python.ASTpy.*;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class FlaskContextExtractor {
//
//    private final List<String> extractedVariables = new ArrayList<>();
//    private final List<String> extractedFunctions = new ArrayList<>();
//    // خريطة لحفظ القيم الحقيقية للمتغيرات لاستخدامها في التوليد
//    private final Map<String, Object> extractedContextData = new HashMap<>();
//
//    public List<String> getExtractedVariables() {
//        return extractedVariables;
//    }
//    public List<String> getExtractedFunctions() {
//        return this.extractedFunctions;
//    }
//    public Map<String, Object> getExtractedContextData() {
//        return extractedContextData;
//    }
//
//    public void extract(PYASTNode node) {
//        if (node == null) return;
//
//        // ==========================================
//        // 1. استخراج تعيينات المتغيرات وقيمها (مثل products = [...])
//        // ==========================================
//        if (node instanceof PYAssignmentNode assignNode) {
//            // استخراج اسم المتغير وقيمته وإضافتها إلى الخريطة
//            String varName = extractVariableName(assignNode.getTarget());
//            Object varValue = evaluatePyValue(assignNode.getValue());
//            if (varName != null && varValue != null) {
//                extractedContextData.put(varName, varValue);
//            }
//        }
//
//        // ==========================================
//        // 2. اصطياد استدعاءات render_template
//        // ==========================================
//        if (node instanceof PYCallExprNode callNode) {
//            if (callNode.getCallee() instanceof PYIdentifierNode idNode) {
//                if ("render_template".equals(idNode.getName())) {
//                    if (callNode.getArguments() != null) {
//                        for (PYArgumentNode arg : callNode.getArguments()) {
//                            if (arg instanceof PYKeyWordArgNode kwArg) {
//                                if (kwArg.getKey() instanceof PYIdentifierNode keyId) {
//                                    extractedVariables.add(keyId.getName());
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//        // ==========================================
//        // 3. تتبع بقية الشجرة (Recursive Traversal)
//        // ==========================================
//        if (node instanceof PYProgramNode progNode) {
//            if (progNode.getStatements() != null) {
//                for (PYStatementNode stmt : progNode.getStatements()) extract(stmt);
//            }
//        }
//        else if (node instanceof PYBlockSuiteNode blockNode) {
//            if (blockNode.getStatements() != null) {
//                for (PYStatementNode stmt : blockNode.getStatements()) extract(stmt);
//            }
//        }
//        else if (node instanceof PYFunctionNode funcNode) {
//            if (funcNode.getFunctionName() != null) extractedFunctions.add(funcNode.getFunctionName());
//            extract(funcNode.getBody());
//        }
//        else if (node instanceof PYForNode forNode) {
//            extract(forNode.getBody());
//        }
//        else if (node instanceof PYIfNode ifNode) {
//            extract(ifNode.getIfBody());
//            if (ifNode.getElseBody() != null) extract(ifNode.getElseBody());
//        }
//        else if (node instanceof PYExprStmtNode exprStmt) {
//            extract(exprStmt.getExpression());
//        }
//        else if (node instanceof PYReturnNode returnNode) {
//            extract(returnNode.getValue());
//        }
//    }
//
//    private String extractVariableName(PYASTNode target) {
//        if (target instanceof PYIdentifierNode id) return id.getName();
//        return null;
//    }
//
//    private Object evaluatePyValue(PYASTNode expr) {
//        // تحويل العقد الثابتة إلى كائنات جافا (Strings, Numbers, Lists, Dicts)
//        if (expr == null) return null;
//        return expr.toString();
//    }
//}

        package python.VisitorPY;

import python.ASTpy.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlaskContextExtractor {

    private final List<String> extractedVariables = new ArrayList<>();
    private final List<String> extractedFunctions = new ArrayList<>();
    private final Map<String, Object> extractedContextData = new HashMap<>();
    // جديد: functionName -> route path الحقيقي من @app.route("...")
    private final Map<String, String> extractedRoutes = new HashMap<>();

    // جديد: يمنع تتبع الإسنادات المحلية (داخل جسم دالة/حلقة/شرط) كأنها بيانات
    // context عامة. بدون هذا، إسناد مثل "product = p" داخل حلقة for داخل
    // route كان يلوّث extractedContextData بقيمة خاطئة ("p" النص الحرفي بدل
    // بيانات المنتج)، ويمنع fallback "مفرد->جمع" الموجود أصلاً في
    // evaluatePyValue من العمل بشكل صحيح.
    private boolean insideFunction = false;

    public List<String> getExtractedVariables() {
        return extractedVariables;
    }

    public List<String> getExtractedFunctions() {
        return this.extractedFunctions;
    }

    public Map<String, Object> getExtractedContextData() {
        return extractedContextData;
    }

    public Map<String, String> getExtractedRoutes() {
        return extractedRoutes;
    }

    public void extract(PYASTNode node) {
        if (node == null) return;

        // ==========================================
        // 1. استخراج تعيينات المتغيرات وقيمها - فقط على المستوى الأعلى
        //    (module level)، وليس داخل أي دالة/حلقة/شرط
        // ==========================================
        if (!insideFunction && node instanceof PYAssignmentNode assignNode) {
            String varName = extractVariableName(assignNode.getTarget());
            Object varValue = evaluatePyValue(assignNode.getValue());
            if (varName != null && varValue != null) {
                extractedContextData.put(varName, varValue);
            }
        }

        // ==========================================
        // 2. اصطياد استدعاءات render_template ونقل البيانات للـ Context
        //    (بلا تغيير - يعمل بغض النظر عن العمق، فهذا هو المصدر الموثوق
        //    الوحيد لقيم الـ kwargs الممرَّرة فعلياً)
        // ==========================================
        if (node instanceof PYCallExprNode callNode) {
            if (callNode.getCallee() instanceof PYIdentifierNode idNode) {
                if ("render_template".equals(idNode.getName())) {
                    if (callNode.getArguments() != null) {
                        for (PYArgumentNode arg : callNode.getArguments()) {
                            if (arg instanceof PYKeyWordArgNode kwArg) {
                                if (kwArg.getKey() instanceof PYIdentifierNode keyId) {
                                    String varName = keyId.getName();
                                    extractedVariables.add(varName);

                                    // تقويم القيمة الممررة وإسنادها لسياق التوليد
                                    Object val = evaluatePyValue(kwArg.getValue());
                                    if (val != null) {
                                        extractedContextData.put(varName, val);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // ==========================================
        // 3. تتبع بقية الشجرة (Recursive Traversal)
        // ==========================================
        if (node instanceof PYProgramNode progNode) {
            if (progNode.getStatements() != null) {
                for (PYStatementNode stmt : progNode.getStatements()) extract(stmt);
            }
        }
        else if (node instanceof PYBlockSuiteNode blockNode) {
            if (blockNode.getStatements() != null) {
                for (PYStatementNode stmt : blockNode.getStatements()) extract(stmt);
            }
        }
        else if (node instanceof PYFunctionNode funcNode) {
            if (funcNode.getFunctionName() != null) extractedFunctions.add(funcNode.getFunctionName());

            // جديد: استخراج مسار الـ route الحقيقي من الـ decorators
            extractRouteFromDecorators(funcNode);

            boolean previousInsideFunction = insideFunction;
            insideFunction = true;
            extract(funcNode.getBody());
            insideFunction = previousInsideFunction;
        }
        else if (node instanceof PYForNode forNode) {
            extract(forNode.getBody());
        }
        else if (node instanceof PYIfNode ifNode) {
            extract(ifNode.getIfBody());
            if (ifNode.getElseBody() != null) extract(ifNode.getElseBody());
        }
        else if (node instanceof PYExprStmtNode exprStmt) {
            extract(exprStmt.getExpression());
        }
        else if (node instanceof PYReturnNode returnNode) {
            extract(returnNode.getValue());
        }
    }

    // جديد: يبحث في decorators الدالة عن @X.route("...") ويخزن مسار الـ
    // route الحقيقي مرتبطاً باسم الدالة، بدلاً من أي hardcoding في Generator
    private void extractRouteFromDecorators(PYFunctionNode funcNode) {
        if (funcNode.getDecorators() == null) return;
        for (PYDecoratorNode dec : funcNode.getDecorators()) {
            String attributeName = null;
            if (dec.getCallee() instanceof PYAttributeExprNode attrExpr) {
                attributeName = attrExpr.getAttribute();
            }
            if (!"route".equals(attributeName)) continue;
            if (dec.getArguments() == null || dec.getArguments().isEmpty()) continue;

            PYArgumentNode firstArg = dec.getArguments().get(0);
            if (firstArg instanceof PYPositionalArgNode posArg
                    && posArg.getValue() instanceof PYStringNode strNode) {
                extractedRoutes.put(funcNode.getFunctionName(), strNode.getValue());
            }
        }
    }
    private String extractVariableName(PYASTNode target) {
        if (target instanceof PYIdentifierNode id) return id.getName();
        return null;
    }

    /**
     * 🔥 تقويم عقد البايثون وتحويلها إلى هياكل بيانات جافا حقيقية (List, Map, String, Number)
     */
    private Object evaluatePyValue(PYASTNode expr) {
        if (expr == null) return null;

        // 1. المعرفات (Identifiers): البحث عنها في الخريطة إن تم تعريفها سابقاً
        // 1. المعرفات (Identifiers): البحث عنها في الخريطة إن تم تعريفها سابقاً
        if (expr instanceof PYIdentifierNode id) {
            String name = id.getName();
            if (extractedContextData.containsKey(name)) {
                return extractedContextData.get(name);
            }

            // 💡 ربط ذكي: إذا كان المتغير مفرداً (مثل product)، ابحث عن الجمع (products) وخذ العينة الأولى
            String pluralName = name + "s";
            if (extractedContextData.containsKey(pluralName)) {
                Object pluralVal = extractedContextData.get(pluralName);
                if (pluralVal instanceof List<?> list && !list.isEmpty()) {
                    return list.get(0); // استخدام المنتج الأول كبيانات للعرض
                }
            }
            return name;
        }

        String nodeType = expr.getClass().getSimpleName();

        // 2. القوائم (Lists): تحويلها إلى Java List<Object>
        if (nodeType.contains("List")) {
            List<Object> listResult = new ArrayList<>();
            List<?> elements = getListProperty(expr, "getElements", "getItems", "getExpressions", "getNodes");
            if (elements != null) {
                for (Object elem : elements) {
                    if (elem instanceof PYASTNode astElem) {
                        listResult.add(evaluatePyValue(astElem));
                    }
                }
            }
            return listResult;
        }

        // 3. القواميس (Dictionaries): تحويلها إلى Java Map<String, Object>
        if (nodeType.contains("Dict")) {
            Map<String, Object> mapResult = new HashMap<>();
            List<?> entries = getListProperty(expr, "getEntries", "getPairs", "getElements", "getItems", "getKvpList");
            if (entries != null) {
                for (Object entry : entries) {
                    if (entry != null) {
                        PYASTNode keyNode = (PYASTNode) invokeMethod(entry, "getKey", "getDictKey");
                        PYASTNode valNode = (PYASTNode) invokeMethod(entry, "getValue", "getDictValue");

                        if (keyNode != null && valNode != null) {
                            Object k = evaluatePyValue(keyNode);
                            Object v = evaluatePyValue(valNode);
                            if (k != null) {
                                mapResult.put(k.toString(), v);
                            }
                        }
                    }
                }
            }
            return mapResult;
        }

        // 4. النصوص والأرقام (Primitives)
        String valStr = getPropertyValue(expr, "getValue", "getText", "getName");
        if (valStr != null) {
            // إزالة الاقتباسات من النصوص
            if ((valStr.startsWith("\"") && valStr.endsWith("\"")) || (valStr.startsWith("'") && valStr.endsWith("'"))) {
                return valStr.substring(1, valStr.length() - 1);
            }
            // تحويل الأرقام
            try {
                if (valStr.contains(".")) return Double.parseDouble(valStr);
                return Integer.parseInt(valStr);
            } catch (NumberFormatException ignored) {}

            return valStr;
        }

        String fallback = expr.toString();
        if (fallback != null && (fallback.startsWith("\"") || fallback.startsWith("'"))) {
            return fallback.substring(1, fallback.length() - 1);
        }
        return fallback;
    }

    // ==========================================
    // 🛠️ دوال مساعدة مرنة للتوافق مع أسماء كلاسات AST المتنوعة
    // ==========================================

    private String getPropertyValue(Object obj, String... methodNames) {
        Object res = invokeMethod(obj, methodNames);
        return res != null ? res.toString() : null;
    }

    @SuppressWarnings("unchecked")
    private List<?> getListProperty(Object obj, String... methodNames) {
        Object res = invokeMethod(obj, methodNames);
        if (res instanceof List<?>) {
            return (List<?>) res;
        }
        return null;
    }

    private Object invokeMethod(Object obj, String... methodNames) {
        if (obj == null) return null;
        for (String mName : methodNames) {
            try {
                Method method = obj.getClass().getMethod(mName);
                return method.invoke(obj);
            } catch (Exception ignored) {}
        }
        return null;
    }
}

