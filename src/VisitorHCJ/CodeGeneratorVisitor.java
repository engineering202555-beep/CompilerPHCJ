//package VisitorHCJ;
//
//import ASTHCJ.*;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.*;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class CodeGeneratorVisitor implements AstVisitor<Void> {
//
//    private final StringBuilder htmlBuilder = new StringBuilder();
//    private Map<String, Object> globalContext = new HashMap<>();
//    private final Deque<Map<String, Object>> scopeStack = new ArrayDeque<>();
//
//    private List<String> flaskVariables = new ArrayList<>();
//    private List<String> flaskFunctions = new ArrayList<>();
//
//    // جديد: functionName -> route path الحقيقي (مثل "/product/<int:product_id>")
//    // مستخرج فعلياً من @app.route(...) عبر FlaskContextExtractor، بدلاً من
//    // أي مسارات مُرمَّزة يدوياً
//    private Map<String, String> flaskRoutes = new HashMap<>();
//
//    public CodeGeneratorVisitor() {}
//
//    public void setRoutes(Map<String, String> extractedRoutes) {
//        if (extractedRoutes != null) {
//            this.flaskRoutes = extractedRoutes;
//        }
//    }
//
//    public void setContext(Map<String, Object> extractedContext) {
//        if (extractedContext != null) {
//            this.globalContext = new HashMap<>(extractedContext);
//        }
//    }
//
//    public void generateOutput(HtmlDocument rootNode, String htmlOutputPath, List<String> flaskVariables, List<String> flaskFunctions) {
//        this.htmlBuilder.setLength(0);
//        this.scopeStack.clear();
//
//        this.flaskVariables = flaskVariables != null ? flaskVariables : new ArrayList<>();
//        this.flaskFunctions = flaskFunctions != null ? flaskFunctions : new ArrayList<>();
//
//        this.scopeStack.push(new HashMap<>(globalContext));
//
//        if (rootNode != null) {
//            rootNode.accept(this);
//        }
//
//        saveToFile(htmlOutputPath, htmlBuilder.toString());
//        System.out.println("🚀 [توليد الكود] تم توليد ملف HTML صافٍ بنجاح في: " + htmlOutputPath);
//    }
//
//    // ===================================================================
//    // 🔍 البحث في النطاقات والتقويم الذكي للتعبيرات (Scope & Dot Access)
//    // ===================================================================
//
//    private Object lookupInScopes(String key) {
//        if (key == null) return null;
//        String cleanKey = cleanString(key);
//        for (Map<String, Object> scope : scopeStack) {
//            for (Map.Entry<String, Object> entry : scope.entrySet()) {
//                if (cleanString(entry.getKey()).equalsIgnoreCase(cleanKey)) {
//                    return entry.getValue();
//                }
//            }
//        }
//        return null;
//    }
//
//    private Object evaluateExpression(AstNode expr) {
//        if (expr == null) return "";
//
//        if (expr instanceof J_JinjaIdentifier idNode) {
//            Object val = lookupInScopes(idNode.getName());
//            return val != null ? val : idNode.getName();
//        }
//        if (expr instanceof J_JinjaStringLiteral strNode) {
//            return cleanString(strNode.getValue());
//        }
//        if (expr instanceof J_JinjaNumberLiteral numNode) {
//            return numNode.getValue();
//        }
//        if (expr instanceof J_JinjaFunctionCall funcCall) {
//            return evaluateFunctionCall(funcCall);
//        }
//
//        // 🔥 استخراج البيانات الحقيقية للخصائص (مثل product.name و product.image و product.price)
//        if (expr instanceof J_JinjaDotAccess dotNode) {
//            Object baseObj = evaluateExpression(dotNode.getBase());
//            String prop = "";
//
//            if (dotNode.getProperty() instanceof J_JinjaIdentifier idProp) {
//                prop = idProp.getName();
//            } else if (dotNode.getProperty() != null) {
//                prop = dotNode.getProperty().toString();
//            }
//            prop = cleanString(prop);
//
//            Map<?, ?> targetMap = null;
//
//            // 1. إذا كان الكائن Map مباشر (مثل p داخل حلقة for)
//            if (baseObj instanceof Map<?, ?> map) {
//                targetMap = map;
//            }
//            // 2. جديد: إذا كان الكائن المُحلَّل بالفعل List (مثل "products" التي
//            //    تُحل مباشرة لقائمة عبر lookupInScopes) - نأخذ أول عنصر، بنفس
//            //    فلسفة "مفرد<->جمع" المستخدمة أصلاً في هذه الدالة، بشكل عام
//            //    لأي List، وليس مُخصَّصاً لاسم "products" تحديداً
//            else if (baseObj instanceof List<?> directList && !directList.isEmpty()) {
//                if (directList.get(0) instanceof Map<?, ?> map) targetMap = map;
//            }
//            // 3. إذا كان الكائن اسماً مفرداً (مثل product)، يبحث عنه أو عن الجمع (products) في النطاقات
//            else if (baseObj != null) {
//                String baseStr = cleanString(baseObj.toString());
//                Object found = lookupInScopes(baseStr);
//
//                if (found instanceof Map<?, ?> map) {
//                    targetMap = map;
//                } else if (found instanceof List<?> list && !list.isEmpty()) {
//                    if (list.get(0) instanceof Map<?, ?> map) targetMap = map;
//                } else {
//                    // البحث الاحتياطي بإضافة s (مثل تحويل product إلى products)
//                    Object pluralFound = lookupInScopes(baseStr + "s");
//                    if (pluralFound instanceof List<?> list && !list.isEmpty()) {
//                        if (list.get(0) instanceof Map<?, ?> map) targetMap = map;
//                    }
//                }
//            }
//
//            // 3. قراءة القيمة الحقيقية من القاموس المطابق
//            if (targetMap != null) {
//                for (Map.Entry<?, ?> entry : targetMap.entrySet()) {
//                    if (entry.getKey() != null) {
//                        String keyStr = cleanString(entry.getKey().toString());
//                        if (keyStr.equalsIgnoreCase(prop)) {
//                            return entry.getValue() != null ? entry.getValue() : "";
//                        }
//                    }
//                }
//            }
//            return "";
//        }
//        return expr.toString();
//    }
//    private String cleanString(String str) {
//        if (str == null) return "";
//        String s = str.trim();
//        if ((s.startsWith("\"") && s.endsWith("\"")) || (s.startsWith("'") && s.endsWith("'"))) {
//            s = s.substring(1, s.length() - 1).trim();
//        }
//        return s;
//    }
//
//    /**
//     * 🔥 تقويم دالة url_for وتوليد المسارات
//     */
//    private Object evaluateFunctionCall(J_JinjaFunctionCall funcCall) {
//        if (funcCall == null) return "";
//
//        String funcName = "";
//        if (funcCall.getFunctionName() instanceof J_JinjaIdentifier id) {
//            funcName = id.getName();
//        }
//
//        if ("url_for".equals(funcName) || funcCall.toString().contains("url_for")) {
//            String endpoint = "";
//            // جديد: كل الـ keyword arguments (وليس آخر واحد فقط)، حتى تدعم
//            // مسارات فيها أكثر من متغير ديناميكي مستقبلاً
//            Map<String, String> paramValues = new HashMap<>();
//
//            if (funcCall.getArguments() != null && !funcCall.getArguments().isEmpty()) {
//                AstNode firstArg = funcCall.getArguments().get(0);
//                Object val = evaluateExpression(firstArg);
//                endpoint = val != null ? cleanString(val.toString()) : "";
//            }
//
//            // إصلاح ضروري: keyword arguments (مثل product_id=p.id) مُخزَّنة في
//            // قائمة منفصلة تماماً (getKeywordArguments())، وليست جزءاً من
//            // getArguments() التي تحوي المعاملات الموضعية فقط. هذا خطأ كان
//            // موجوداً مسبقاً قبل أي تعديل مني (الحلقة القديمة على
//            // getArguments() لم تكن تصل أبداً لأي keyword argument).
//            if (funcCall.getKeywordArguments() != null) {
//                for (J_JinjaKeywordArgument kw : funcCall.getKeywordArguments()) {
//                    Object kwVal = evaluateExpression(kw.getValue());
//                    String kwName = kw.getName() != null ? kw.getName().getName() : "";
//                    if (kwVal != null) paramValues.put(kwName, cleanString(kwVal.toString()));
//                }
//            }
//
//            // المسار الحقيقي المستخرج فعلياً من @app.route(...) في بايثون
//            String routeTemplate = flaskRoutes.get(endpoint);
//            if (routeTemplate != null) {
//                return substituteRoutePlaceholders(routeTemplate, paramValues);
//            }
//
//            // احتياطي فقط إن لم يوجد مسار مُستخرَج لهذا الـ endpoint إطلاقاً
//            // (بدل الانهيار) - لا "تخمين" لصيغة مسار غير معروفة
//            String fallbackParam = paramValues.values().stream().findFirst().orElse("");
//            return "/" + endpoint + (fallbackParam.isEmpty() ? "" : "/" + fallbackParam);
//        }
//        return "";
//    }
//
//    // جديد: يستبدل كل جزء <[type:]name> في مسار route حقيقي بقيمته الفعلية
//    // من keyword arguments التي مُرِّرت لـ url_for(...)
//    private String substituteRoutePlaceholders(String routeTemplate, Map<String, String> paramValues) {
//        Pattern placeholderPattern = Pattern.compile("<(?:\\w+:)?(\\w+)>");
//        Matcher matcher = placeholderPattern.matcher(routeTemplate);
//        StringBuilder result = new StringBuilder();
//        int lastEnd = 0;
//        while (matcher.find()) {
//            result.append(routeTemplate, lastEnd, matcher.start());
//            String paramName = matcher.group(1);
//            String value = paramValues.getOrDefault(paramName, matcher.group());
//            result.append(value);
//            lastEnd = matcher.end();
//        }
//        result.append(routeTemplate.substring(lastEnd));
//        return result.toString();
//    }
//
//    // ===================================================================
//    // 🌐 دوال الزيارة المعالجة (Visitors)
//    // ===================================================================
//
//    @Override
//    public Void visitHtmlDocument(HtmlDocument node) {
//        if (node == null) return null;
//        if (node.getDoctype() != null) node.getDoctype().accept(this);
//        if (node.getNodes() != null) {
//            for (HtmlNode child : node.getNodes()) {
//                if (child != null) child.accept(this);
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public Void visitDoctype(DoctypeNode node) {
//        htmlBuilder.append("<!DOCTYPE html>\n");
//        return null;
//    }
//
//    @Override
//    public Void visitPairedTag(PairedTag node) {
//        if (node == null) return null;
//        htmlBuilder.append("<").append(node.getTagName());
//        if (node.getAttributes() != null) {
//            for (HtmlAttribute attr : node.getAttributes()) {
//                if (attr != null) {
//                    htmlBuilder.append(" ");
//                    attr.accept(this);
//                }
//            }
//        }
//        htmlBuilder.append(">\n");
//
//        if (node.getChildren() != null) {
//            for (AstNode child : node.getChildren()) {
//                if (child != null) child.accept(this);
//            }
//        }
//        htmlBuilder.append("</").append(node.getTagName()).append(">\n");
//        return null;
//    }
//
//    @Override
//    public Void visitSelfClosingTag(SelfClosingTag node) {
//        if (node == null) return null;
//        htmlBuilder.append("<").append(node.getTagName());
//        if (node.getAttributes() != null) {
//            for (HtmlAttribute attr : node.getAttributes()) {
//                if (attr != null) {
//                    htmlBuilder.append(" ");
//                    attr.accept(this);
//                }
//            }
//        }
//        htmlBuilder.append("/>\n");
//        return null;
//    }
//
//    @Override
//    public Void visitTextContent(TextContent node) {
//        if (node != null && node.getText() != null) {
//            htmlBuilder.append(node.getText());
//        }
//        return null;
//    }
//    @Override
//    public Void visitStyleContent(StyleContent node) {
//        htmlBuilder.append("<style>\n");
//        if (node != null && node.getCss() != null) {
//            node.getCss().accept(this);
//        }
//        htmlBuilder.append("</style>\n");
//        return null;
//    }
//
//    @Override
//    public Void visitBooleanAttribute(BooleanAttribute node) {
//        if (node != null && node.getName() != null) {
//            htmlBuilder.append(node.getName());
//        }
//        return null;
//    }
//
//    @Override
//    public Void visitAttributeWithValue(AttributeWithValue node) {
//        if (node == null) return null;
//        htmlBuilder.append(node.getName()).append("=\"");
//        if (node.getValue() != null) {
//            node.getValue().accept(this);
//        }
//        htmlBuilder.append("\"");
//        return null;
//    }
//
//    @Override
//    public Void visitStringValue(StringValue node) {
//        if (node != null && node.getValue() != null) {
//            htmlBuilder.append(node.getValue());
//        }
//        return null;
//    }
//
//    @Override
//    public Void visitJinjaVariable(J_JinjaVariableNode node) {
//        if (node != null && node.getExpression() != null) {
//            Object val = evaluateExpression(node.getExpression());
//            htmlBuilder.append(val != null ? val.toString() : "");
//        }
//        return null;
//    }
//
//    @Override
//    public Void visitJinjaFunctionCall(J_JinjaFunctionCall node) {
//        Object val = evaluateFunctionCall(node);
//        if (val != null) {
//            htmlBuilder.append(val.toString());
//        }
//        return null;
//    }
//
//    @Override
//    public Void visitJinjaForNode(J_JinjaForNode node) {
//        if (node == null) return null;
//
//        Object collection = evaluateExpression(node.getIterable());
//
//        if (collection instanceof String strCol) {
//            Object scoped = lookupInScopes(strCol);
//            if (scoped != null) collection = scoped;
//        }
//
//        String varName = "p";
//        if (node.getVariable() != null && !node.getVariable().isEmpty()) {
//            AstNode varNode = node.getVariable().get(0);
//            if (varNode instanceof J_JinjaIdentifier idNode) {
//                varName = idNode.getName();
//            }
//        }
//
//        if (collection instanceof Iterable<?> iterable) {
//            for (Object item : iterable) {
//                Map<String, Object> localScope = new HashMap<>();
//                localScope.put(varName, item);
//
//                scopeStack.push(localScope);
//
//                if (node.getBody() != null) {
//                    for (AstNode child : node.getBody()) {
//                        if (child != null) child.accept(this);
//                    }
//                }
//
//                scopeStack.pop();
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public Void visitCompositeAttributeValue(J_CompositeAttributeValue node) {
//        if (node != null && node.getParts() != null) {
//            for (AstNode p : node.getParts()) {
//                if (p != null) p.accept(this);
//            }
//        }
//        return null;
//    }
//
//    // ===================================================================
//    // 🎨 تفريغ قواعد الـ CSS الثانوية
//    // ===================================================================
//
//    @Override public Void visitCssStyleSheet(CssStyleSheetNode node) { if (node != null && node.getRules() != null) for (CssRuleNode r : node.getRules()) if (r != null) r.accept(this); return null; }
//    @Override public Void visitCssRule(CssRuleNode node) { if (node == null) return null; if (node.getSelector() != null) node.getSelector().accept(this); htmlBuilder.append(" {\n"); if (node.getDeclarations() != null) for (CssDeclarationNode d : node.getDeclarations()) if (d != null) { htmlBuilder.append(" "); d.accept(this); } htmlBuilder.append("}\n"); return null; }
//
//
//
//    @Override public Void visitCssSelector(CssSelectorNode node) { if (node != null && node.getText() != null) htmlBuilder.append(node.getText()); return null; }
//    @Override public Void visitCssDeclaration(CssDeclarationNode node) { if (node == null) return null; htmlBuilder.append(node.getProperty()).append(": "); if (node.getValue() != null) node.getValue().accept(this); htmlBuilder.append(";\n"); return null; }
//    @Override
//    public Void visitCssCompositeValue(CssCompositeValueNode node) {
//        if (node != null && node.getParts() != null) {
//            for (CssValueNode p : node.getParts()) { // 👈 تم تغيير النوع هنا إلى CssValueNode
//                if (p != null) {
//                    p.accept(this);
//                    htmlBuilder.append(" ");
//                }
//            }
//        }
//        return null;
//    }
//    @Override public Void visitCssNumberValue(CssNumberValueNode node) { if (node != null) htmlBuilder.append(node.getValue()); return null; }
//    @Override public Void visitCssUnitValue(CssUnitValueNode node) { if (node != null) htmlBuilder.append(node.getUnit()); return null; }
//    @Override public Void visitCssIdentifierValue(CssIdentifierValueNode node) { if (node != null) htmlBuilder.append(node.getName()); return null; }
//    @Override public Void visitCssKeywordValue(CssKeywordValueNode node) { if (node != null) htmlBuilder.append(node.getKeyword()); return null; }
//    @Override public Void visitCssColorValue(CssColorValueNode node) { if (node != null) htmlBuilder.append(node.getColor()); return null; }
//    @Override public Void visitCssFunctionValue(CssFunctionValueNode node) { if (node == null) return null; htmlBuilder.append(node.getFunctionName()).append("("); if (node.getArguments() != null) for (CssValuePartNode a : node.getArguments()) if (a != null) a.accept(this); htmlBuilder.append(")"); return null; }
//
//    @Override public Void visitJinjaIdentifier(J_JinjaIdentifier node) { return null; }
//    @Override public Void visitJinjaStringLiteral(J_JinjaStringLiteral node) { return null; }
//    @Override public Void visitJinjaNumberLiteral(J_JinjaNumberLiteral node) { return null; }
//    @Override public Void visitJinjaDotAccess(J_JinjaDotAccess node) { return null; }
//    @Override public Void visitJinjaIndexAccessNode(J_JinjaIndexAccessNode node) { return null; }
//    @Override public Void visitJinjaFilterNode(J_JinjaFilterNode node) { return null; }
//    @Override public Void visitJinjaLoopVariable(J_JinjaLoopVariable node) { return null; }
//    @Override public Void visitJinjaKeywordArgument(J_JinjaKeywordArgument node) { return null; }
//
//    private void saveToFile(String filePath, String content) {
//        try {
//            File file = new File(filePath);
//            if (file.getParentFile() != null) file.getParentFile().mkdirs();
//            try (FileWriter writer = new FileWriter(file)) {
//                writer.write(content);
//            }
//        } catch (IOException e) {
//            System.err.println("❌ خطأ أثناء حفظ الملف: " + e.getMessage());
//        }
//    }
//}
package VisitorHCJ;

import ASTHCJ.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeGeneratorVisitor implements AstVisitor<Void> {

    private final StringBuilder htmlBuilder = new StringBuilder();
    private Map<String, Object> globalContext = new HashMap<>();
    private final Deque<Map<String, Object>> scopeStack = new ArrayDeque<>();

    private List<String> flaskVariables = new ArrayList<>();
    private List<String> flaskFunctions = new ArrayList<>();

    private Map<String, String> flaskRoutes = new HashMap<>();

    public CodeGeneratorVisitor() {}

    public void setRoutes(Map<String, String> extractedRoutes) {
        if (extractedRoutes != null) {
            this.flaskRoutes = extractedRoutes;
        }
    }

    public void setContext(Map<String, Object> extractedContext) {
        if (extractedContext != null) {
            this.globalContext = new HashMap<>(extractedContext);
        }
    }

    public void generateOutput(HtmlDocument rootNode, String htmlOutputPath, List<String> flaskVariables, List<String> flaskFunctions) {
        this.htmlBuilder.setLength(0);
        this.scopeStack.clear();

        this.flaskVariables = flaskVariables != null ? flaskVariables : new ArrayList<>();
        this.flaskFunctions = flaskFunctions != null ? flaskFunctions : new ArrayList<>();

        this.scopeStack.push(new HashMap<>(globalContext));

        if (rootNode != null) {
            rootNode.accept(this);
        }

        saveToFile(htmlOutputPath, htmlBuilder.toString());
        System.out.println("🚀 [توليد الكود] تم توليد ملف HTML صافٍ بنجاح في: " + htmlOutputPath);
    }

    // ===================================================================
    // 🔍 البحث في النطاقات والتقويم الذكي للتعبيرات (Scope & Dot Access)
    // ===================================================================

    private Object lookupInScopes(String key) {
        if (key == null) return null;
        String cleanKey = cleanString(key);
        for (Map<String, Object> scope : scopeStack) {
            for (Map.Entry<String, Object> entry : scope.entrySet()) {
                if (cleanString(entry.getKey()).equalsIgnoreCase(cleanKey)) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    private Object evaluateExpression(AstNode expr) {
        if (expr == null) return "";

        if (expr instanceof J_JinjaIdentifier idNode) {
            Object val = lookupInScopes(idNode.getName());
            return val != null ? val : idNode.getName();
        }
        if (expr instanceof J_JinjaStringLiteral strNode) {
            return cleanString(strNode.getValue());
        }
        if (expr instanceof J_JinjaNumberLiteral numNode) {
            return numNode.getValue();
        }
        if (expr instanceof J_JinjaFunctionCall funcCall) {
            return evaluateFunctionCall(funcCall);
        }

        if (expr instanceof J_JinjaDotAccess dotNode) {
            Object baseObj = evaluateExpression(dotNode.getBase());
            String prop = "";

            if (dotNode.getProperty() instanceof J_JinjaIdentifier idProp) {
                prop = idProp.getName();
            } else if (dotNode.getProperty() != null) {
                prop = dotNode.getProperty().toString();
            }
            prop = cleanString(prop);

            Map<?, ?> targetMap = null;

            if (baseObj instanceof Map<?, ?> map) {
                targetMap = map;
            } else if (baseObj instanceof List<?> directList && !directList.isEmpty()) {
                if (directList.get(0) instanceof Map<?, ?> map) targetMap = map;
            } else if (baseObj != null) {
                String baseStr = cleanString(baseObj.toString());
                Object found = lookupInScopes(baseStr);
                if (found instanceof Map<?, ?> map) {
                    targetMap = map;
                } else if (found instanceof List<?> list && !list.isEmpty()) {
                    if (list.get(0) instanceof Map<?, ?> map) targetMap = map;
                } else {
                    Object pluralFound = lookupInScopes(baseStr + "s");
                    if (pluralFound instanceof List<?> list && !list.isEmpty()) {
                        if (list.get(0) instanceof Map<?, ?> map) targetMap = map;
                    }
                }
            }

            if (targetMap != null) {
                for (Map.Entry<?, ?> entry : targetMap.entrySet()) {
                    if (entry.getKey() != null) {
                        String keyStr = cleanString(entry.getKey().toString());
                        if (keyStr.equalsIgnoreCase(prop)) {
                            return entry.getValue() != null ? entry.getValue() : "";
                        }
                    }
                }
            }
            return "";
        }
        return expr.toString();
    }

    private String cleanString(String str) {
        if (str == null) return "";
        String s = str.trim();
        if ((s.startsWith("\"") && s.endsWith("\"")) || (s.startsWith("'") && s.endsWith("'"))) {
            s = s.substring(1, s.length() - 1).trim();
        }
        return s;
    }

    private Object evaluateFunctionCall(J_JinjaFunctionCall funcCall) {
        if (funcCall == null) return "";

        String funcName = "";
        if (funcCall.getFunctionName() instanceof J_JinjaIdentifier id) {
            funcName = id.getName();
        }

        if ("url_for".equals(funcName) || funcCall.toString().contains("url_for")) {
            String endpoint = "";
            Map<String, String> paramValues = new HashMap<>();

            if (funcCall.getArguments() != null && !funcCall.getArguments().isEmpty()) {
                AstNode firstArg = funcCall.getArguments().get(0);
                Object val = evaluateExpression(firstArg);
                endpoint = val != null ? cleanString(val.toString()) : "";
            }

            if (funcCall.getKeywordArguments() != null) {
                for (J_JinjaKeywordArgument kw : funcCall.getKeywordArguments()) {
                    Object kwVal = evaluateExpression(kw.getValue());
                    String kwName = kw.getName() != null ? kw.getName().getName() : "";
                    if (kwVal != null) paramValues.put(kwName, cleanString(kwVal.toString()));
                }
            }

            String routeTemplate = flaskRoutes.get(endpoint);
            if (routeTemplate != null) {
                return substituteRoutePlaceholders(routeTemplate, paramValues);
            }

            String fallbackParam = paramValues.values().stream().findFirst().orElse("");
            return "/" + endpoint + (fallbackParam.isEmpty() ? "" : "/" + fallbackParam);
        }
        return "";
    }

    private String substituteRoutePlaceholders(String routeTemplate, Map<String, String> paramValues) {
        Pattern placeholderPattern = Pattern.compile("<(?:\\w+:)?(\\w+)>");
        Matcher matcher = placeholderPattern.matcher(routeTemplate);
        StringBuilder result = new StringBuilder();
        int lastEnd = 0;
        while (matcher.find()) {
            result.append(routeTemplate, lastEnd, matcher.start());
            String paramName = matcher.group(1);
            String value = paramValues.getOrDefault(paramName, matcher.group());
            result.append(value);
            lastEnd = matcher.end();
        }
        result.append(routeTemplate.substring(lastEnd));
        return result.toString();
    }

// ===================================================================
// 🌐 دوال الزيارة المعالجة (Visitors)
// ===================================================================
@Override
public Void visitHtmlDocument(HtmlDocument node) {
    if (node == null) return null;
    if (node.getDoctype() != null) node.getDoctype().accept(this);
    if (node.getNodes() != null) {
        for (HtmlNode child : node.getNodes()) {
            if (child != null) child.accept(this);
        }
    }
    return null;
}

    @Override
    public Void visitDoctype(DoctypeNode node) {
        htmlBuilder.append("<!DOCTYPE html>\n");
        return null;
    }

    @Override
    public Void visitPairedTag(PairedTag node) {
        if (node == null) return null;
        htmlBuilder.append("<").append(node.getTagName());
        if (node.getAttributes() != null) {
            for (HtmlAttribute attr : node.getAttributes()) {
                if (attr != null) {
                    htmlBuilder.append(" ");
                    attr.accept(this);
                }
            }
        }
        htmlBuilder.append(">\n");

        if (node.getChildren() != null) {
            for (AstNode child : node.getChildren()) {
                if (child != null) child.accept(this);
            }
        }
        htmlBuilder.append("</").append(node.getTagName()).append(">\n");
        return null;
    }

    @Override
    public Void visitSelfClosingTag(SelfClosingTag node) {
        if (node == null) return null;
        htmlBuilder.append("<").append(node.getTagName());
        if (node.getAttributes() != null) {
            for (HtmlAttribute attr : node.getAttributes()) {
                if (attr != null) {
                    htmlBuilder.append(" ");
                    attr.accept(this);
                }
            }
        }
        htmlBuilder.append("/>\n");
        return null;
    }

    @Override
    public Void visitTextContent(TextContent node) {
        if (node != null && node.getText() != null) {
            htmlBuilder.append(node.getText());
        }
        return null;
    }

    @Override
    public Void visitStyleContent(StyleContent node) {
        // تم تعطيل طباعة أوسمة <style> لضمان فصل الـ CSS بالكامل
        return null;
    }

    @Override
    public Void visitBooleanAttribute(BooleanAttribute node) {
        if (node != null && node.getName() != null) {
            htmlBuilder.append(node.getName());
        }
        return null;
    }

    @Override
    public Void visitAttributeWithValue(AttributeWithValue node) {
        if (node == null) return null;
        htmlBuilder.append(node.getName()).append("=\"");
        if (node.getValue() != null) {
            node.getValue().accept(this);
        }
        htmlBuilder.append("\"");
        return null;
    }

    @Override
    public Void visitStringValue(StringValue node) {
        if (node != null && node.getValue() != null) {
            htmlBuilder.append(node.getValue());
        }
        return null;
    }

    @Override
    public Void visitJinjaVariable(J_JinjaVariableNode node) {
        if (node != null && node.getExpression() != null) {
            Object val = evaluateExpression(node.getExpression());
            htmlBuilder.append(val != null ? val.toString() : "");
        }
        return null;
    }

    @Override
    public Void visitJinjaFunctionCall(J_JinjaFunctionCall node) {
        Object val = evaluateFunctionCall(node);
        if (val != null) {
            htmlBuilder.append(val.toString());
        }
        return null;
    }

    @Override
    public Void visitJinjaForNode(J_JinjaForNode node) {
        if (node == null) return null;

        Object collection = evaluateExpression(node.getIterable());

        if (collection instanceof String strCol) {
            Object scoped = lookupInScopes(strCol);
            if (scoped != null) collection = scoped;
        }

        String varName = "p";
        if (node.getVariable() != null && !node.getVariable().isEmpty()) {
            AstNode varNode = node.getVariable().get(0);
            if (varNode instanceof J_JinjaIdentifier idNode) {
                varName = idNode.getName();
            }
        }
        if (collection instanceof Iterable<?> iterable) {
            for (Object item : iterable) {
                Map<String, Object> localScope = new HashMap<>();
                localScope.put(varName, item);

                scopeStack.push(localScope);

                if (node.getBody() != null) {
                    for (AstNode child : node.getBody()) {
                        if (child != null) child.accept(this);
                    }
                }

                scopeStack.pop();
            }
        }
        return null;
    }

    @Override
    public Void visitCompositeAttributeValue(J_CompositeAttributeValue node) {
        if (node != null && node.getParts() != null) {
            for (AstNode p : node.getParts()) {
                if (p != null) p.accept(this);
            }
        }
        return null;
    }

    // ===================================================================
    // 🎨 قواعد الـ CSS الفرعية
    // ===================================================================

    @Override public Void visitCssStyleSheet(CssStyleSheetNode node) { return null; }
    @Override public Void visitCssRule(CssRuleNode node) { return null; }
    @Override public Void visitCssSelector(CssSelectorNode node) { return null; }
    @Override public Void visitCssDeclaration(CssDeclarationNode node) { return null; }
    @Override public Void visitCssCompositeValue(CssCompositeValueNode node) { return null; }
    @Override public Void visitCssNumberValue(CssNumberValueNode node) { return null; }
    @Override public Void visitCssUnitValue(CssUnitValueNode node) { return null; }
    @Override public Void visitCssIdentifierValue(CssIdentifierValueNode node) { return null; }
    @Override public Void visitCssKeywordValue(CssKeywordValueNode node) { return null; }
    @Override public Void visitCssColorValue(CssColorValueNode node) { return null; }
    @Override public Void visitCssFunctionValue(CssFunctionValueNode node) { return null; }

    @Override public Void visitJinjaIdentifier(J_JinjaIdentifier node) { return null; }
    @Override public Void visitJinjaStringLiteral(J_JinjaStringLiteral node) { return null; }
    @Override public Void visitJinjaNumberLiteral(J_JinjaNumberLiteral node) { return null; }
    @Override public Void visitJinjaDotAccess(J_JinjaDotAccess node) { return null; }
    @Override public Void visitJinjaIndexAccessNode(J_JinjaIndexAccessNode node) { return null; }
    @Override public Void visitJinjaFilterNode(J_JinjaFilterNode node) { return null; }
    @Override public Void visitJinjaLoopVariable(J_JinjaLoopVariable node) { return null; }
    @Override public Void visitJinjaKeywordArgument(J_JinjaKeywordArgument node) { return null; }

    private void saveToFile(String filePath, String content) {
        try {
            File file = new File(filePath);
            if (file.getParentFile() != null) file.getParentFile().mkdirs();
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(content);
            }
        } catch (IOException e) {
            System.err.println("❌ خطأ أثناء حفظ الملف: " + e.getMessage());
        }
    }
}




