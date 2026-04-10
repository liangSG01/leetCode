//package JMeter压测;
//
//import java.io.OutputStream;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.concurrent.*;
//import java.util.concurrent.atomic.AtomicInteger;
//
//public class TicketPressureTest {
//
//    // 接口地址
//    private static final String URL_PATH = "http://localhost:8080/api/ticket/purchase";
//    private static final int THREAD_COUNT = 500;   // 并发线程数
//    private static final int REQUEST_COUNT = 5000; // 总请求数
//    // 统计指标
//    private static final AtomicInteger successCount = new AtomicInteger(0);
//
//    private static final AtomicInteger failCount = new AtomicInteger(0);
//
//    public static void main(String[] args) throws Exception {
//        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
//        CountDownLatch latch = new CountDownLatch(REQUEST_COUNT);
//
//        long startTime = System.currentTimeMillis();
//
//        for (int i = 0; i < REQUEST_COUNT; i++) {
//            int userId = i + 1;
//            int trainId = (i % 20) + 1;  // 模拟20列车
//            executor.submit(() -> {
//                try {
//                    int code = sendRequest(trainId, userId);
//                    if (code == 200) {
//                        successCount.incrementAndGet();
//                    } else {
//                        failCount.incrementAndGet();
//                    }
//                } catch (Exception e) {
//                    failCount.incrementAndGet();
//                } finally {
//                    latch.countDown();
//                }
//            });
//        }
//
//        latch.await(); // 等所有线程完成
//        executor.shutdown();
//
//        long endTime = System.currentTimeMillis();
//        long totalTime = endTime - startTime;
//
//        double tps = successCount.get() / (totalTime / 1000.0);
//
//        System.out.println("====== 压测结果 ======");
//        System.out.println("总请求数：" + REQUEST_COUNT);
//        System.out.println("成功数：" + successCount);
//        System.out.println("失败数：" + failCount);
//        System.out.println("总耗时：" + totalTime + " ms");
//        System.out.println("TPS：" + String.format("%.2f", tps));
//    }
//
//    private static int sendRequest(int trainId, int userId) throws Exception {
//        //json "train":1,"userId":1
//        String json = String.format("\"train\":%d,\"userId\":%d",trainId,userId);
////        URL url = new URL(URL_PATH);
////        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        HttpURLConnection conn = new HttpURLConnection(URL);
//        conn.setRequestMethod("POST");
//        conn.setRequestProperty("Content-Type", "application/json");
//        conn.setDoOutput(true);
//
//        try (OutputStream os = conn.getOutputStream()) {
//            os.write(json.getBytes());
//            os.flush();
//        }
//
//        int code = conn.getResponseCode();
//        conn.disconnect();
//        return code;
//    }
//}
