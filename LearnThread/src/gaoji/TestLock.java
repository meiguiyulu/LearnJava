package gaoji;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LYJ
 * @create 2021-04-30 20:52
 * 测试Lock锁
 */
public class TestLock {

    public static void main(String[] args) {
        TestLock2 lock = new TestLock2();
        new Thread(lock, "小明").start();
        new Thread(lock, "小孩").start();
        new Thread(lock, "老司机").start();
    }

}

class TestLock2 implements Runnable{
    private int tickNums = 10;

    //定义Lock
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true){
            try {
            /**
             * 保证线程安全的代码
             */
                lock.lock();//加锁
                if (tickNums>0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+tickNums--);
                }
                else break;
            }finally {
                //解锁
                lock.unlock();
                /**
                 * 如果同步代码有异常，要将unlock()写入finally语句块
                 */
            }
        }
    }
}
