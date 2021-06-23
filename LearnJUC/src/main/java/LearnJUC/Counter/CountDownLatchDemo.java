package LearnJUC.Counter;

import java.util.concurrent.CountDownLatch;

/**
 * @author LYJ
 * @create 2021-05-06 21:19
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        // 倒计时的总数是6
        CountDownLatch latch = new CountDownLatch(6);

        for (int i=0;i<6;++i){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + " Go Out!");
                latch.countDown(); // 减1
            }, String.valueOf(i)).start();
        }
        latch.await(); //等待计数器减为0以后才往下执行；若不加这一行代码，下面的代码不会最后执行，显然是不对的
        System.out.println("Close Door");
    }
}
