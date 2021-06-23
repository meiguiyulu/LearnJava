package LearnJUC.BlockQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author LYJ
 * @create 2021-05-07 21:28
 *
 * 和其他的BlockingQueue不一样。
 * 进去一个元素，必须等待取出来之后，才能再往里面放一个元素！
 * 只有 put()、take()两个方法
 */
public class SynchronousDemo {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new SynchronousQueue<>();

        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName() + "写入1");
                queue.put(1);
                System.out.println(Thread.currentThread().getName() + "写入2");
                queue.put(2);
                System.out.println(Thread.currentThread().getName() + "写入3");
                queue.put(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程1").start();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + "取出" + queue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + "取出" + queue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + "取出" + queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程2").start();
    }
}
