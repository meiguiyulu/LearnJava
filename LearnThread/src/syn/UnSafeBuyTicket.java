package syn;

/**
 * @author LYJ
 * @create 2021-04-30 10:46
 * 不安全的买票
 * 线程不安全，有负数
 * 添加synchronized
 */
public class UnSafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket ticket = new BuyTicket();
        new Thread(ticket, "小明").start();
        new Thread(ticket, "老师").start();
        new Thread(ticket, "黄牛党").start();
    }
}

class BuyTicket implements Runnable{
    //票数
    private int ticketNums = 10;
    private boolean flag = true; //外部停止方式

    @Override
    public void run() {
        //买票
        while (flag){
            buy();
        }
    }

    //synchronized同步方法，锁的是this
    private synchronized void buy(){
        //判断是否有票
        if (ticketNums<=0){
            flag = false;
            return;
        }
        //模拟延时
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+"拿到"+ticketNums--);
    }
}
