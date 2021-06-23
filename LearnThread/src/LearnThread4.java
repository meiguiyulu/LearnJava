/**
 * @author LYJ
 * @create 2021-04-28 20:44
 * //多个线程同时操作同一个接口
 * //买火车票的例子
 */
public class LearnThread4 implements Runnable{

    //票数
    private int tickerNums = 10;

    @Override
    public void run() {
        while (true){
            if (tickerNums<=0)
                break;;
            System.out.println(Thread.currentThread().getName() + "-->抢到了第" + tickerNums-- + "张票");
        }
    }

    public static void main(String[] args) {
        LearnThread4 thread = new LearnThread4();

        new Thread(thread, "小明").start();
        new Thread(thread, "老师").start();
        new Thread(thread, "黄牛党").start();
    }
}
