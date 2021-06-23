package LearnJUC.Lock8;

import java.util.concurrent.TimeUnit;

/**
 * @author LYJ
 * @create 2021-05-04 15:17
 * 一个静态同步方法、一个普通同步方法，哪个先执行？  先执行了打电话
 */
public class Test6 {
    public static void main(String[] args) {
        Phone6 phone = new Phone6();

        new Thread(()->{
            phone.SendMessage();
        }, "A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            phone.Call();
        }, "B").start();

       // new Thread(()->phone.Hello(), "C").start();
    }
}

class Phone6{
    //静态同步方法
    public static synchronized void SendMessage(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Send Message!");
    }

    // 普通同步方法
    public synchronized void Call(){
        System.out.println("Phone Call！");
    }

    public void Hello(){
        System.out.println("Hello");
    }
}
