package LearnJUC.Lock8;

import java.util.concurrent.TimeUnit;

/**
 * @author LYJ
 * @create 2021-05-04 14:40
 * 8锁：关于锁的8个问题
 * 1.标准情况下，两个线程先执行哪一个？
 *          运行结果：先执行 phone.SendMessage(); 然后再执行phone.Call();
 * 2. 发短信延迟4s，还是先执行了 phone.SendMessage()
 *
 * 原因：synchronized锁的对象是方法的调用者
 */
public class Test1 {
    public static void main(String[] args) {
        Phone phone = new Phone();

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
    }
}

class Phone{
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
}
