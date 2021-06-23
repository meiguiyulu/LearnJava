package ThreadState;

/**
 * @author LYJ
 * @create 2021-04-29 20:19
 * 测试礼让线程
 * 礼让不一定成功，看CPU心情
 */
public class TestYield{
    public static void main(String[] args) {
        MyYield yield = new MyYield();

        new Thread(yield, "A").start();
        new Thread(yield, "B").start();
    }
}

class MyYield implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程开始执行");
        Thread.yield(); // 线程礼让
        System.out.println(Thread.currentThread().getName() + "线程结束执行");
    }
}

