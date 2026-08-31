import python.SemanticPY.PythonSemanticAnalyzer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * مكوّن مستقل مسؤول فقط عن تجميع نتائج Semantic Analysis (من أي مصدر: Python
 * أو HTML/CSS/Jinja) وكتابتها كتقرير نصي واحد.
 *
 * تصميم متعمَّد: لا يعرف هذا الكلاس كيف يُبنى الـ AST أو كيف يعمل أي Analyzer -
 * فقط يستقبل نتائج جاهزة (قوائم أخطاء) ويُنسّقها. هذا يطابق نفس مبدأ الفصل الذي
 * التزم به المشروع أصلاً بين Symbol Table (تحليل) و Context Data (توليد):
 * هنا نفصل بين "إنتاج الأخطاء" (كل Analyzer مسؤول عنه) و"تقرير الأخطاء" (هذا
 * الكلاس فقط).
 *
 * يمكن استخدامه من أي Runner اختباري، ولاحقاً من src/Main.java نفسه دون تعديل
 * أي منطق تحليل - فقط استبدال السطر الحالي الذي يكتب عدد الأخطاء فقط
 * (semanticAnalyzer.getErrorCount()) باستدعاء هذا الكلاس بدلاً منه.
 */
public class SemanticReportWriter {

    private final StringBuilder report = new StringBuilder();

    public void addPythonFileSection(String fileName, List<PythonSemanticAnalyzer.PythonSemanticError> errors) {
        report.append("================================================\n");
        report.append("FILE: ").append(fileName).append("\n");
        report.append("================================================\n");

        if (errors == null || errors.isEmpty()) {
            report.append("No semantic errors found.\n");
        } else {
            report.append(errors.size()).append(" semantic error(s):\n");
            for (PythonSemanticAnalyzer.PythonSemanticError e : errors) {
                report.append("[").append(e.getErrorType()).append("] Line ").append(e.getLine()).append("\n");
                if (e.getVariableName() != null) {
                    report.append("variable: ").append(e.getVariableName()).append("\n");
                }
                report.append("message: ").append(e.getMessage()).append("\n");
            }
        }
        report.append("\n");
    }

    public void addHtmlFileSection(String fileName, List<String> errors) {
        report.append("================================================\n");
        report.append("FILE: ").append(fileName).append("\n");
        report.append("================================================\n");

        if (errors == null || errors.isEmpty()) {
            report.append("No semantic errors found.\n");
        } else {
            report.append(errors.size()).append(" semantic error(s):\n");
            for (String e : errors) {
                report.append(e).append("\n");
            }
        }
        report.append("\n");
    }

    public String getReportText() {
        return report.toString();
    }

    public void writeToFile(String outputPath) throws IOException {
        Path path = Path.of(outputPath);
        if (path.getParent() != null) {
            Files.createDirectories(path.getParent());
        }
        Files.writeString(path, report.toString());
    }
}
 