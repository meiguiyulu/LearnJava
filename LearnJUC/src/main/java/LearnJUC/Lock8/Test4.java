package LearnJUC.Lock8;

import java.util.concurrent.TimeUnit;

/**
 * @author LYJ
 * @create 2021-05-04 15:06
 * 5. 增加两个静态的同步方法，一个对象，先执行发短信还是打电话？  //先执行的发短信
 */
public class Test4 {
    public static void main(String[] args) {
        Phone4 phone = new Phone4();

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

        //new Thread(()->phone.Hello(), "C").start();
    }
}

class Phone4{
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
