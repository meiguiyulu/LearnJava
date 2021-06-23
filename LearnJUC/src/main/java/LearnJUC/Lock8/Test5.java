package LearnJUC.Lock8;

import java.util.concurrent.TimeUnit;

/**
 * @author LYJ
 * @create 2021-05-04 15:12
 * 6. 锁静态方法；两个对象    发短信
 */
public class Test5 {

    public static void main(String[] args) {
        // 两个对象，两把锁！
        Phone5 phone1 = new Phone5();
        Phone5 phone2 = new Phone5();
        // 此时，phone1 phone2加锁的对象都是Phone5的class模板，每个类只有一个class模板

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

class Phone5{
    /**
     * 原因：synchronized锁的对象是方法的调用者
     * static是静态方法
     * 这样的话，锁的是class，每一个类的class都全局唯一
     * 所以下面两个static文件锁的是同一个class文件
     */
    public static synchronized void SendMessage(){
        System.out.println("Send Message!");
    }

    public static synchronized void Call(){
        System.out.println("Phone Call！");
    }

    // 这里没有锁！不是同步方法，不受锁的影响
    public void Hello(){
        System.out.println("Hello");
    }
}
