/**
 * @author LYJ
 * @create 2021-04-26 20:30
 */
// 多个线程同时操作同一个对象
// 买火车票的例子

    //发现问题：多个线程操作同一个资源的情况下，线程不安全，数据紊乱。
public class LearnThread1 implements Runnable{

    private int ticket = 10;

    @Override
    public void run() {
        while (true){
            if (ticket<=0)
                break;
            try {
                Thread.sleep(200);
            } catch (InterruptedException e){
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "抢到第" + ticket-- + "张票");
        }
    }
    public static void main(String[] args){
        LearnThread1 thread = new LearnThread1();

        new Thread(thread, "小明").start();
        new Thread(thread, "老师").start();
        new Thread(thread, "黄牛").start();
    }
}
