package LearnJUC.CAS;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LYJ
 * @create 2021-05-13 17:39
 */
public class SoluABA {
    public static void main(String[] args) {
        // Integer
        AtomicStampedReference<Integer> atomic = new AtomicStampedReference<>(12, 1);


        // 与乐观锁原理相同
        new Thread(()->{
            int stamp = atomic.getStamp(); // 获得版本号
            System.out.println(Thread.currentThread().getName() + "1:\t" + stamp);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomic.compareAndSet(12, 13,
                    atomic.getStamp(), atomic.getStamp() + 1));
            System.out.println(Thread.currentThread().getName() + "2:\t" + atomic.getStamp());
            System.out.println(atomic.compareAndSet(13, 12,
                    atomic.getStamp(), atomic.getStamp() + 1));
            System.out.println(Thread.currentThread().getName() + "3:\t" + atomic.getStamp());
        }, "A").start();

        new Thread(()->{
            int stamp = atomic.getStamp(); // 获得版本号
            System.out.println(Thread.currentThread().getName() + "1:\t" + stamp);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomic.compareAndSet(12, 16,
                    stamp, stamp + 1));
            System.out.println(Thread.currentThread().getName() + "2:\t" + atomic.getStamp());
        }, "B").start();

    }
}
