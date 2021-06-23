package LearnJUC.ThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author LYJ
 * @create 2021-05-09 16:07
 * 拒绝策略：
 * new ThreadPoolExecutor.AbortPolicy()
 *      线程数量超过最大承载量(阻塞队列的capacity + maximumPoolSize)以后，抛出异常
 * new ThreadPoolExecutor.CallerRunsPolicy()
 *      线程数量超过最大承载量(阻塞队列的capacity + maximumPoolSize)以后，由调用者所在的线程来执行任务
 * new ThreadPoolExecutor.DiscardPolicy()
 *      队列满了就丢掉任务，不抛出异常
 * new ThreadPoolExecutor.DiscardOldestPolicy()
 *      队列满了，尝试去和最早的竞争，不会抛出异常
 */
public class Demo2 {
    public static void main(String[] args) {
        // 自定义线程池! 工作中只能使用 ThreadPoolExecutor 创建
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                Runtime.getRuntime().availableProcessors(), // 获取自己电脑是几核的
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );

        try {
            // 最大承载：阻塞队列的capacity + maximumPoolSize
            // 超出最大承载：触发拒绝策略 java.util.concurrent.RejectedExecutionException
            for (int i = 1; i <= 9; i++) {
                executor.execute(()->{
                    System.out.println(Thread.currentThread().getName() + "===>OK");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭线程池
            executor.shutdown();
        }
    }
}
