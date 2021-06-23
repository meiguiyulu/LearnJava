package LearnJUC.Lock8;

import java.util.concurrent.TimeUnit;

/**
 * @author LYJ
 * @create 2021-05-04 15:02
 * 两个对象，两个同步方法，先发短信还是先打电话？ //先打电话
 */
public class Test3 {
    public static void main(String[] args) {
        //两个对象，两个调用者；两个不同的锁
        Phone3 phone1 = new Phone3();
        Phone3 phone2 = new Phone3();

        new Thread(()->{
            phone1.SendMessage();
        }, "A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            phone2.Call();
        }, "B").start();

        //new Thread(()->phone.Hello(), "C").start();
    }
}

class Phone3{
    /**
     * 原因：synchronized锁的对象是方法的调用者
     * 下面两个方法用的是同一个锁(phone的锁)，谁先拿到谁先执行
     */
    public synchronized void SendMessage(){
        System.out.println("Send Message!");
    }

    public synchronized void Call(){
        System.out.println("Phone Call！");
    }

    // 这里没有锁！不是同步方法，不受锁的影响
    public void Hello(){
        System.out.println("Hello");
    }
}
