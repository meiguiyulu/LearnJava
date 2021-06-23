package LearnJUC.LearnLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author LYJ
 * @create 2021-05-14 15:04
 * 自旋锁
 */
public class SpinlockDemo {

    AtomicReference<Thread> reference = new AtomicReference<>();

    // 加锁
    public void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + " ==> myLock");

        // 自旋锁
        while (!reference.compareAndSet(null, thread)){
        }
    }
    // 解锁
    public void myUnLock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + " ==> myUnLock");
        reference.compareAndSet(thread, null);
    }

    public static void main(String[] args) throws InterruptedException {
        SpinlockDemo lock = new SpinlockDemo();

        new Thread(()->{
            lock.myLock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                lock.myUnLock();
            }
        }, "Thread1").start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{
            lock.myLock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.myUnLock();
            }
        }, "Thread2").start();
    }
}
