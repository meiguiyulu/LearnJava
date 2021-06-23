package LearnJUC.LearnVolatile;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author LYJ
 * @create 2021-05-13 9:43
 * Volatile不保证原子性
 */
public class VolatileDemo {
    private volatile static AtomicInteger num = new AtomicInteger(); // 原子类的Integer

    public synchronized static void Plus(){
//        ++num; // 不是原子性操作
        num.getAndIncrement(); // AtomicInteger的+1操作 (CAS)
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    Plus();
                }
            }).start();
        }
        System.out.println(Thread.currentThread().getName() + "===>" + num);
    }
}
