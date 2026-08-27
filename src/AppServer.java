
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

public class AppServer {


private static final int PORT = 8080;

// ============================================================
// PROJECT PATHS
// ============================================================

    private static final Path PROJECT_ROOT =
            Paths.get("")
                    .toAbsolutePath()
                    .normalize();

    // المشروع الداخلي الذي يحتوي src
    private static final Path SOURCE_ROOT =
            PROJECT_ROOT

                    .resolve("src");

    // Tests
    private static final Path TESTS_DIR =
            SOURCE_ROOT.resolve("Tests");

    // ملفات HTML/Jinja
    private static final Path TEMPLATES_DIR =
            SOURCE_ROOT.resolve("TestHtmlCJ");

    // ملف الإدخال
    private static final Path PYTHON_FILE =
            TESTS_DIR.resolve("test1.txt");

    // المخرجات
    private static final Path OUTPUT_DIR =
            PROJECT_ROOT.resolve("output");

    private static final Path COMPILER_OUTPUT_DIR =
            PROJECT_ROOT.resolve("compiler_output");

    public static void main(String[] args) throws IOException {



            System.out.println("🔥🔥🔥 APP SERVER MAIN STARTED 🔥🔥🔥");

            System.out.println(
                    "WORKING DIRECTORY = "
                            + Paths.get("")
                            .toAbsolutePath()
                            .normalize()
            );



            System.out.println("🔥 قبل CompilerRunner.main()");

            try {

                CompilerRunner.main(args);

            } catch (Exception e) {

                System.err.println(
                        "❌ خطأ في CompilerRunner: "
                                + e.getMessage()
                );

                e.printStackTrace();
            }

            System.out.println("🔥 بعد CompilerRunner.main()");

            startFileWatcher();

            HttpServer server =
                    HttpServer.create(
                            new InetSocketAddress(PORT),
                            0
                    );

            server.createContext(
                    "/",
                    new RouterHandler()
            );

            server.setExecutor(null);

            System.out.println(
                    "🌐 [Localhost] السيرفر يعمل على: "
                            + "http://localhost:"
                            + PORT
            );

            server.start();
        }

    private static void startFileWatcher() {

        Thread watchThread =
                new Thread(() -> {

                    try {

                        /*
                         * نستخدم نفس المسار الذي استخدمناه في
                         * CompilerRunner و FileWatcher.
                         */

                        Path path =
                                TESTS_DIR
                                        .toAbsolutePath()
                                        .normalize();


                        if (!Files.exists(path)) {

                            System.err.println(
                                    "❌ مجلد Tests غير موجود: "
                                            + path
                            );

                            return;
                        }


                        WatchService watchService =
                                FileSystems
                                        .getDefault()
                                        .newWatchService();


                        path.register(
                                watchService,
                                StandardWatchEventKinds.ENTRY_MODIFY,
                                StandardWatchEventKinds.ENTRY_CREATE
                        );


                        System.out.println(
                                "👀 [WatchService] المراقبة الحية نشطة للمجلد: "
                                        + path
                        );


                        while (
                                !Thread.currentThread()
                                        .isInterrupted()
                        ) {

                            WatchKey key =
                                    watchService.take();


                            for (
                                    WatchEvent<?> event :
                                    key.pollEvents()
                            ) {

                                WatchEvent.Kind<?> kind =
                                        event.kind();


                                Path changedFile =
                                        (Path) event.context();


                                if (
                                        kind ==
                                                StandardWatchEventKinds.ENTRY_MODIFY
                                                &&
                                                changedFile
                                                        .toString()
                                                        .endsWith("test1.txt")
                                ) {

                                    System.out.println(
                                            "\n⚡ [Regeneration] تم رصد تعديل، جاري إعادة التوليد..."
                                    );


                                    /*
                                     * مهلة بسيطة لمنع تكرار الحدث
                                     * بسبب طريقة حفظ الملف.
                                     */

                                    Thread.sleep(200);


                                    CompilerRunner.main(null);
                                }
                            }


                            boolean valid =
                                    key.reset();


                            if (!valid) {
                                break;
                            }
                        }

                    } catch (Exception e) {

                        System.err.println(
                                "❌ خطأ في مراقب الملفات: "
                                        + e.getMessage()
                        );
                    }

                });


        /*
         * يتوقف تلقائيًا عند إغلاق البرنامج.
         */

        watchThread.setDaemon(true);

        watchThread.start();
    }


    // ================================================================
    // Router Handler
    // ================================================================

    static class RouterHandler
            implements HttpHandler {

        @Override
        public void handle(
                HttpExchange exchange
        ) {

            try {

                String path =
                        exchange
                                .getRequestURI()
                                .getPath();


                String method =
                        exchange.getRequestMethod();


                // ====================================================
                // POST Requests
                // ====================================================

                if ("POST".equalsIgnoreCase(method)) {

                    if (
                            path.startsWith("/add")
                                    ||
                                    path.contains("add_product")
                    ) {handleAddProduct(exchange);

                        return;

                    } else if (
                            path.startsWith("/delete")
                    ) {

                        handleDeleteProduct(
                                exchange,
                                path
                        );

                        return;
                    }
                }


                // ====================================================
                // تحديد ملف HTML المطلوب
                // ====================================================

                String fileToServe =
                        "index.html";


                if (
                        path.startsWith("/add")
                                ||
                                path.contains("add_product")
                ) {

                    fileToServe =
                            "add_product.html";

                } else if (
                        path.startsWith("/product")
                                ||
                                path.contains("details")
                                ||
                                path.contains("edit_product")
                ) {

                    fileToServe =
                            "edit_product.html";

                } else if (
                        path.endsWith(".css")
                ) {

                    fileToServe =
                            "style.css";

                } else if (
                        path.endsWith(".js")
                ) {

                    fileToServe =
                            "script.js";
                }


                // ====================================================
                // إرسال الملف
                // ====================================================

                serveStaticFile(
                        exchange,
                        fileToServe
                );


            } catch (Exception e) {

                System.err.println(
                        "❌ خطأ أثناء معالجة الطلب: "
                                + e.getMessage()
                );

            } finally {

                exchange.close();
            }
        }


        // ============================================================
        // Add Product
        // ============================================================

        private void handleAddProduct(
                HttpExchange exchange
        ) throws IOException {

            byte[] bodyBytes =
                    exchange
                            .getRequestBody()
                            .readAllBytes();


            String formData =
                    new String(
                            bodyBytes,
                            StandardCharsets.UTF_8
                    );


            Map<String, String> params =
                    parseFormData(formData);


            String name =
                    params.getOrDefault(
                            "name",
                            "منتج جديد"
                    );


            String price =
                    params.getOrDefault(
                            "price",
                            "0"
                    );


            String image =
                    params.getOrDefault(
                            "image",
                            "https://via.placeholder.com/200"
                    );


            String details =
                    params.getOrDefault(
                            "details",
                            "تفاصيل المنتج"
                    );


            // ========================================================
            // 1. إدراج المنتج في ملف Python
            // ========================================================

            insertProductIntoPythonList(
                    name,
                    price,
                    image,
                    details
            );
            // ========================================================
            // 2. إعادة التوليد
            // ========================================================




            // ========================================================
            // 3. العودة إلى الصفحة الرئيسية
            // ========================================================

            redirectToHome(exchange);
        }


        // ============================================================
        // Insert Product Into Python List
        // ============================================================

        private void insertProductIntoPythonList(
                String name,
                String price,
                String image,
                String details
        ) throws IOException {

            Path path =
                    PYTHON_FILE;


            String content =
                    Files.readString(path);


            int newId =
                    (int)
                            (System.currentTimeMillis() % 10000);


            String newProductDict =
                    String.format(
                            "\n    {\n"
                                    + "        \"id\": %d,\n"
                                    + "        \"name\": \"%s\",\n"
                                    + "        \"price\": %s,\n"
                                    + "        \"image\": \"%s\",\n"
                                    + "        \"details\": \"%s\"\n"
                                    + "    },",
                            newId,
                            name,
                            price,
                            image,
                            details
                    );


            // ========================================================
            // البحث عن products = [
            // ========================================================

            int index =
                    content.indexOf(
                            "products = ["
                    );


            String productsPrefix;


            if (index != -1) {

                productsPrefix =
                        "products = [";

            } else {

                index =
                        content.indexOf(
                                "products=["
                        );

                productsPrefix =
                        "products=[";
            }


            if (index != -1) {

                int insertPos =
                        index
                                + productsPrefix.length();


                String updatedContent =
                        content.substring(
                                0,
                                insertPos
                        )
                                + newProductDict
                                + content.substring(
                                insertPos
                        );


                Files.writeString(
                        path,
                        updatedContent
                );


                System.out.println(
                        "⚡ [Server Action] تم إدراج المنتج سكونياً داخل products = [...] بنجاح: "
                                + name
                );

            } else {

                System.err.println(
                        "❌ لم يتم العثور على قائمة products = [ في ملف البايثون!"
                );
            }
        }


// ============================================================
// Delete Product
// ============================================================
private void handleDeleteProduct(
        HttpExchange exchange,
        String path
) throws IOException {

    String[] parts =
            path.split("/");


    String targetIdStr =
            parts[parts.length - 1];


    try {

        int targetId =
                Integer.parseInt(
                        targetIdStr
                );


        // ====================================================
        // 1. حذف المنتج من Python
        // ====================================================

        removeProductFromPythonFile(
                targetId
        );


        // ====================================================
        // 2. إعادة التوليد
        // ====================================================

        System.out.println(
                "⚡ [Server Action] جاري إعادة التوليد بعد الحذف..."
        );





    } catch (NumberFormatException e) {

        System.err.println(
                "❌ لم يتم تحديد ID المنتج بشكل صحيح: "
                        + targetIdStr
        );

    } catch (Exception e) {

        System.err.println(
                "❌ خطأ أثناء إعادة التوليد بعد الحذف: "
                        + e.getMessage()
        );
    }


    // ========================================================
    // 3. العودة للصفحة الرئيسية
    // ========================================================

    redirectToHome(exchange);
}


        // ============================================================
        // Remove Product From Python File
        // ============================================================

        private void removeProductFromPythonFile(
                int targetId
        ) throws IOException {

            Path path =
                    PYTHON_FILE;


            String content =
                    Files.readString(path);


            String idPattern =
                    "\"id\": " + targetId;


            int idPos =
                    content.indexOf(idPattern);


            if (idPos != -1) {

                int dictStart =
                        content.lastIndexOf(
                                "{",
                                idPos
                        );


                int dictEnd =
                        content.indexOf(
                                "}",
                                idPos
                        );


                if (
                        dictStart != -1
                                &&
                                dictEnd != -1
                ) {

                    dictEnd =
                            dictEnd + 1;


                    /*
                     * إزالة الفاصلة والمسافات
                     * الموجودة بعد الـ dictionary.
                     */

                    while (
                            dictEnd < content.length()
                                    &&
                                    (
                                            content.charAt(dictEnd) == ','
                                                    ||
                                                    Character.isWhitespace(
                                                            content.charAt(dictEnd)
                                                    )
                                    )
                    ) {

                        if (
                                content.charAt(dictEnd)
                                        == ','
                        ) {

                            dictEnd++;

                            break;
                        }

                        dictEnd++;
                    }
                    String updatedContent =
                            content.substring(
                                    0,
                                    dictStart
                            )
                                    +
                                    content.substring(
                                            dictEnd
                                    );


                    Files.writeString(
                            path,
                            updatedContent
                    );


                    System.out.println(
                            "⚡ [Server Action] تم حذف المنتج رقم ("
                                    + targetId
                                    + ") سكونياً من الملف بنجاح."
                    );


                    return;
                }
            }


            System.err.println(
                    "❌ لم يتم العثور على المنتج رقم ("
                            + targetId
                            + ") داخل القائمة."
            );
        }


        // ============================================================
        // Serve Static File
        // ============================================================

        private void serveStaticFile(
                HttpExchange exchange,
                String fileName
        ) throws IOException {

            Path filePath =
                    OUTPUT_DIR.resolve(fileName);


            if (
                    Files.exists(filePath)
                            &&
                            !Files.isDirectory(filePath)
            ) {

                byte[] bytes =
                        Files.readAllBytes(filePath);


                exchange
                        .getResponseHeaders()
                        .set(
                                "Content-Type",
                                getContentType(fileName)
                        );


                exchange.sendResponseHeaders(
                        200,
                        bytes.length
                );


                try (
                        OutputStream os =
                                exchange.getResponseBody()
                ) {

                    os.write(bytes);
                }


            } else {

                String response =
                        "404 Not Found";


                exchange.sendResponseHeaders(
                        404,
                        response.getBytes(
                                StandardCharsets.UTF_8
                        ).length
                );


                try (
                        OutputStream os =
                                exchange.getResponseBody()
                ) {

                    os.write(
                            response.getBytes(
                                    StandardCharsets.UTF_8
                            )
                    );
                }
            }
        }


        // ============================================================
        // Redirect
        // ============================================================

        private void redirectToHome(
                HttpExchange exchange
        ) throws IOException {

            exchange
                    .getResponseHeaders()
                    .set(
                            "Location",
                            "/"
                    );


            exchange.sendResponseHeaders(
                    302,
                    -1
            );
        }


        // ============================================================
        // Parse Form Data
        // ============================================================

        private Map<String, String> parseFormData(
                String formData
        ) throws UnsupportedEncodingException {

            Map<String, String> map =
                    new HashMap<>();


            if (
                    formData == null
                            ||
                            formData.isEmpty()
            ) {

                return map;
            }
            for (
                    String pair :
                    formData.split("&")
            ) {

                String[] kv =
                        pair.split("=",
                                2);


                if (kv.length > 1) {

                    map.put(
                            URLDecoder.decode(
                                    kv[0],
                                    StandardCharsets.UTF_8
                            ),
                            URLDecoder.decode(
                                    kv[1],
                                    StandardCharsets.UTF_8
                            )
                    );
                }
            }


            return map;
        }


        // ============================================================
        // Content Type
        // ============================================================

        private String getContentType(
                String path
        ) {

            if (path.endsWith(".html")) {

                return "text/html; charset=UTF-8";

            }


            if (path.endsWith(".css")) {

                return "text/css; charset=UTF-8";

            }


            if (path.endsWith(".js")) {

                return "application/javascript; charset=UTF-8";

            }


            return "text/plain";
        }
    }
}



