package LearnJUC.Counter;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author LYJ
 * @create 2021-05-07 19:25
 * 停车位  抢车
 * 6个车 三个车位
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        // 参数：permits 线程数量
        Semaphore semaphore = new Semaphore(3);
        for (int i=0;i<=6;++i){
            new Thread(()->{
                // acquire() 得到
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"抢到车位");
                    TimeUnit.SECONDS.sleep(2); // 模拟停车  停两秒钟
                    System.out.println(Thread.currentThread().getName()+"离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // release() 释放
                    semaphore.release();
                }
            }).start();
        }
    }
}
