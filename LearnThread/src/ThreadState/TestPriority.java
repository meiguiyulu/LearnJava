package ThreadState;

/**
 * @author LYJ
 * @create 2021-04-29 21:28
 * 测试线程的优先级
 */
public class TestPriority {
    public static void main(String[] args) {
        //主线程的默认优先级
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
        MyPriority priority = new MyPriority();

        Thread t1 = new Thread(priority);
        Thread t2 = new Thread(priority);
        Thread t3 = new Thread(priority);
        Thread t4 = new Thread(priority);
        Thread t5 = new Thread(priority);
        Thread t6 = new Thread(priority);

        /**
         * 先设置优先级，再启动线程
         */
        t1.start();
        t2.setPriority(1);
        t2.start();
        t3.setPriority(4);
        t3.start();
        t4.setPriority(Thread.MAX_PRIORITY); // 10
        t4.start();
        t5.setPriority(8);
        t5.start();
        t6.setPriority(7);
        t6.start();

    }
}

class MyPriority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
    }
}
