



import java.io.IOException;
import java.nio.file.*;
// ============================================================
// 2. تحديد مسار المشروع بطريقة نسبية
// ============================================================
//
// Working Directory الذي تأكدنا منه هو:
//
// CompilerPythonHtmlCSSJinja-main
//
// وداخل هذا المجلد يوجد:
//
// CompilerPythonHtmlCSSJinja-main
//     └── src
//         └── Tests
//             └── test1.txt
//
// لذلك لا نستخدم أي C:/... هنا.
public class FileWatcher {

    public static void main(String[] args) {

        // ============================================================
        // 1. تشغيل التوليد المرة الأولى عند بدء تشغيل المراقب
        // ============================================================

        try {
            System.out.println("🚀 [Start] تشغيل التوليد الأولي للمشروع...");
          CompilerRunner.main(args);

        } catch (Exception e) {
            System.err.println("❌ خطأ في التوليد الأولي: " + e.getMessage());
        }



        // ============================================================

        Path projectRoot =
                Paths.get("")
                        .toAbsolutePath()
                        .normalize();

        Path sourceRoot =
                projectRoot

                        .resolve("src");

        Path testsDir =
                sourceRoot.resolve("Tests");

        String watchDir =
                testsDir.toString();

        String targetFile =
                "test1.txt";


        // ============================================================
        // 3. بدء عملية المراقبة الحية
        // ============================================================

        startListening(
                watchDir,
                targetFile,
                () -> {

                    try {

                        System.out.println(
                                "🔄 [Auto-Rebuild] إعادة تشغيل CompilerRunner تلقائياً..."
                        );

                        CompilerRunner.main(null);

                    } catch (Exception e) {

                        System.err.println(
                                "❌ خطأ أثناء إعادة التوليد: "
                                        + e.getMessage()
                        );
                    }
                }
        );


        // ============================================================
        // 4. إبقاء الخيط الرئيسي يعمل
        // ============================================================

        try {

            Thread.currentThread().join();

        } catch (InterruptedException e) {

            System.out.println(
                    "🛑 تم إنهاء المراقبة."
            );
        }
    }


    /**
     * تشغيل مراقب الملفات في خيط مستقل
     * لمنع تجميد البرنامج الرئيسي.
     */
    public static void startListening(
            String directoryPath,
            String targetFileName,
            Runnable onChangeAction
    ) {

        Thread watchThread =
                new Thread(() -> {

                    try {

                        // ====================================================
                        // إنشاء WatchService
                        // ====================================================

                        WatchService watchService =
                                FileSystems
                                        .getDefault()
                                        .newWatchService();


                        // تحويل مسار المجلد إلى Path
                        Path path =
                                Paths.get(directoryPath);


                        // ====================================================
                        // تسجيل المجلد للمراقبة
                        // ====================================================
                        path.register(
                                watchService,
                                StandardWatchEventKinds.ENTRY_MODIFY,
                                StandardWatchEventKinds.ENTRY_CREATE
                        );


                        System.out.println(
                                "👀 [WatchService] المراقبة الحية نشطة للمجلد: "
                                        + path
                        );


                        // ====================================================
                        // حلقة المراقبة
                        // ====================================================

                        while (!Thread.currentThread().isInterrupted()) {

                            WatchKey key =
                                    watchService.take();


                            // =================================================
                            // قراءة الأحداث التي حدثت
                            // =================================================

                            for (WatchEvent<?> event :
                                    key.pollEvents()) {

                                WatchEvent.Kind<?> kind =
                                        event.kind();


                                Path changedFile =
                                        (Path) event.context();


                                // =================================================
                                // التحقق من أن الملف المطلوب هو الذي تغير
                                // =================================================

                                if (
                                        kind ==
                                                StandardWatchEventKinds.ENTRY_MODIFY
                                                &&
                                                changedFile
                                                        .toString()
                                                        .endsWith(targetFileName)
                                ) {

                                    System.out.println(
                                            "\n⚡ [Regeneration] تم رصد تعديل في الملف: "
                                                    + changedFile
                                    );


                                    // =================================================
                                    // مهلة بسيطة لمنع تكرار الحدث
                                    // بسبب طريقة حفظ نظام التشغيل للملف
                                    // =================================================

                                    Thread.sleep(200);


                                    // =================================================
                                    // إعادة التوليد
                                    // =================================================

                                    onChangeAction.run();
                                }
                            }


                            // =================================================
                            // إعادة تفعيل المفتاح للمراقبة
                            // =================================================

                            boolean valid =
                                    key.reset();


                            if (!valid) {
                                break;
                            }
                        }


                    } catch (InterruptedException e) {

                        System.out.println(
                                "🛑 تم إيقاف مراقب الملفات."
                        );


                    } catch (IOException e) {

                        System.err.println(
                                "❌ خطأ في نظام مراقبة الملفات: "
                                        + e.getMessage()
                        );
                    }


                });
// ================================================================
        // جعل Thread تابعًا للبرنامج الرئيسي
        // ================================================================

        watchThread.setDaemon(true);

        watchThread.start();
    }
}