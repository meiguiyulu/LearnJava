package LearnJUC.Lock8;

import java.util.concurrent.TimeUnit;

/**
 * @author LYJ
 * @create 2021-05-04 14:57
 * 增加一个普通方法以后，先执行的Hello，后执行的发短信。
 */
public class Test2 {
    public static void main(String[] args) {
        Phone2 phone = new Phone2();

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

        new Thread(()->phone.Hello(), "C").start();
    }
}

class Phone2{
    /**
     * 原因：synchronized锁的对象是方法的调用者
     * 下面两个方法用的是同一个锁(phone的锁)，谁先拿到谁先执行
     */
    public synchronized void SendMessage(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
