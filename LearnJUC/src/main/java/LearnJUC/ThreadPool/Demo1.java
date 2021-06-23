package LearnJUC.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author LYJ
 * @create 2021-05-08 15:07
 *
 * Executors 三大方法
 *
 */
public class Demo1 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();// 单个线程
        //ExecutorService service = Executors.newFixedThreadPool(5);// 创建固定数量大小的线程池
        //ExecutorService service = Executors.newCachedThreadPool();// 大小可伸缩的线程池

        try {
            for (int i = 0; i < 10; i++) {
                // 使用线程池之后，要使用线程池创建线程
                service.execute(()->{
                    System.out.println(Thread.currentThread().getName() + "==>OK");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 线程池使用完以后，先关闭线程池
            service.shutdown();
        }
    }
}
