package LearnJUC.BlockQueue;

import java.util.Collections;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author LYJ
 * @create 2021-05-07 20:42
 */
public class BlockQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        // Test1();
        // Test2();
        // Test3();
        Test4();
    }
    /**
     * 抛出异常
     */
    public static void Test1(){
        // 需要初始化队列的大小
        ArrayBlockingQueue queue = new ArrayBlockingQueue<>(3);
        System.out.println(queue.add(1));
        System.out.println(queue.add(2));
        System.out.println(queue.add(3));
        // 队列已经满了
        //System.out.println(queue.add(4)); // java.lang.IllegalStateException: Queue full


        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        // System.out.println(queue.remove()); // java.util.NoSuchElementException
        System.out.println(queue.element()); // 查看队首元素是谁  java.util.NoSuchElementException
    }
    /**
     * 有返回值，不抛出异常
     */
    public static void Test2(){
        ArrayBlockingQueue queue = new ArrayBlockingQueue(3);

        System.out.println(queue.offer(1)); // true
        System.out.println(queue.offer(2)); // true
        System.out.println(queue.offer(3)); // true
        System.out.println(queue.offer(4)); // 返回false, 不抛出异常

        System.out.println(queue.poll()); // 1
        System.out.println(queue.poll()); // 2
        System.out.println(queue.poll()); // 3
        System.out.println(queue.poll()); // 返回null, 不抛出异常
        System.out.println(queue.peek());
    }

    /**
     * 等待，阻塞（一直阻塞）
     */
    public static void Test3() throws InterruptedException {
        ArrayBlockingQueue queue = new ArrayBlockingQueue(3);
        queue.put(1);
        queue.put(2);
        queue.put(3);
        // queue.put(4); // 阻塞

        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take()); // 阻塞
    }

    /**
     * 等待，阻塞（超时等待）
     */
    public static void Test4() throws InterruptedException {
        ArrayBlockingQueue queue = new ArrayBlockingQueue(3);

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4, 2, TimeUnit.SECONDS); // 等待超过2s就退出

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll(2, TimeUnit.SECONDS)); // 等待超过2s就退出
    }
}
