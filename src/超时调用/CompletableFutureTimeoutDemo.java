package 超时调用;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CompletableFutureTimeoutDemo {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("[Main] 提交一个 10 秒的慢任务...");

        // 1. 异步提交一个 "慢任务"
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("... [SlowTask] 开始执行，需要10秒...");
                Thread.sleep(10000); // 模拟 10 秒的长时间工作
                System.out.println("... [SlowTask] 终于执行完毕。");
                return "任务成功返回的结果";
            } catch (InterruptedException e) {
                System.out.println("... [SlowTask] 被中断了。");
                return "任务被取消";
            }
        });

        // 2. 核心：非阻塞地链式调用 orTimeout()
        // 我们只给它 3 秒时间
        cf.orTimeout(3, TimeUnit.SECONDS)

                // 3. (成功路径) 如果在3秒内完成，则执行这里
                .thenAccept(result -> {
                    System.out.println("[Main] 成功拿到结果: " + result);
                })

                // 4. (失败路径) 如果超时(或发生其他异常)，则执行这里
                .exceptionally(ex -> {
                    // 检查异常是不是 TimeoutException
                    if (ex instanceof TimeoutException) {
                        System.out.println("[Main] 不等了，任务超时！(TimeoutException)");
                    } else {
                        System.out.println("[Main] 任务执行出错: " + ex.getMessage());
                    }
                    return null; // exceptionally 块必须返回一个值 (null 即可)
                });

        // 5. Main 线程完全没有被阻塞，可以继续做别的事情
        System.out.println("[Main] Main 线程继续执行其他工作...");

        // 6. (仅为Demo) 保持主线程存活，以便观察异步任务的结果
        // 否则 main 线程会立刻退出
        Thread.sleep(15000);

        System.out.println("[Main] Demo 结束。");
    }
}