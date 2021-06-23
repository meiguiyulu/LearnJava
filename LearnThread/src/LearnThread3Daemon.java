/**
 * @author LYJ
 * @create 2021-04-27 18:06
 */
public class LearnThread3Daemon {
    public static void main(String[] args) {
        God god = new God();
        Person person = new Person();

        Thread thread = new Thread(god);
        thread.setDaemon(true); // 默认false表示用户线程
        thread.start(); //守护线程开启

        new Thread(person).start();//用户线程开启
    }
}

class God implements Runnable{
    @Override
    public void run() {
        while (true)
            System.out.println("The God Bless You！");
    }
}

class Person implements Runnable{
    @Override
    public void run() {
        for (int i=1;i<=100;i++){
            System.out.println("知足常乐：生活第" + i + "年");
        }
        System.out.println("==========================================");
        System.out.println("再见了，这个世界");
        System.out.println("==========================================");
    }
}

