package ThreadState;

/**
 * @author LYJ
 * @create 2021-04-29 20:00
 */
/**
模拟网络延时：放大问题的发生性.
 */
public class TestSleep implements Runnable{
    private int ticketNums = 10;//票数
    @Override
    public void run() {
        while (true){
            if (ticketNums<=0)
                break;
            //模拟延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"抢到了第" +  ticketNums-- + "张票");
        }
    }

    public static void main(String[] args) {
        TestSleep sleep = new TestSleep();

        new Thread(sleep, "小明").start();
        new Thread(sleep, "老师").start();
        new Thread(sleep, "黄牛").start();
    }
}
