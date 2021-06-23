package LearnJUC.Future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author LYJ
 * @create 2021-05-12 19:50
 * 异步调用
 *  三个部分：
 *      1. 异步执行
 *      2. 成功回调
 *      3. 失败回调
 */
public class Demo01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         *         没有返回值的 runAsync 异步回调
         *         CompletableFuture<Void> future = CompletableFuture.runAsync(()->{
         *             try {
         *                 TimeUnit.SECONDS.sleep(2);
         *             } catch (InterruptedException e) {
         *                 e.printStackTrace();
         *             }
         *             System.out.println(Thread.currentThread().getName() + "runAsync");
         *         });
         *         System.out.println("================>");
         *         future.get(); // 获取执行结果
         */
        // 有返回值的异步回调
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "============>");
            int i = 10/ 0;
            return 1024;
        });
        future.whenComplete((u1, u2)->{
            System.out.println(u1); // 正常的返回结果
            System.out.println(u2); // 错误的信息
        }).exceptionally((e)->{
            e.printStackTrace();
            return 233; // 执行错误的时候的返回值
        }).get();
    }
}
