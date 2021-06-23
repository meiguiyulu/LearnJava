package LearnJUC;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LYJ
 * @create 2021-05-04 9:57
 */
public class SaleTicketLock {
    public static void main(String[] args) {
        Ticket2 ticket = new Ticket2();

        new Thread(()->{for (int i=0;i<40;i++) ticket.sale();}, "A").start();
        new Thread(()->{for (int i=0;i<40;i++) ticket.sale();}, "B").start();
        new Thread(()->{for (int i=0;i<40;i++) ticket.sale();}, "C").start();
    }
}

/**
 * Lock步骤
 * 1. new ReentrantLock()
 * 2. lock.lock()
 * 3. lock.unlock()
 */

class Ticket2{
    private int number = 30;

    Lock lock = new ReentrantLock();

    public void sale(){

        lock.lock();//加锁
        try {
            //业务代码
            if (number>0){
                System.out.println(Thread.currentThread().getName()
                        +"卖出了"+(50-number+1)+"张票，剩余"+(--number));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock(); //解码
        }

    }
}
