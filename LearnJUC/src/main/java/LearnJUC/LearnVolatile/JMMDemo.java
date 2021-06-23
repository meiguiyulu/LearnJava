package LearnJUC.LearnVolatile;

import java.util.concurrent.TimeUnit;

/**
 * @author LYJ
 * @create 2021-05-12 21:14
 */
public class JMMDemo {
    // 不加volatile程序会陷入死循环
    // 加volatile会保证程序的可见性
    private volatile static int num=0;
    public static void main(String[] args) throws InterruptedException { // main线程

        new Thread(()->{ // 线程1
            while (num==0){
            }
        }).start();
        TimeUnit.SECONDS.sleep(1);
        num = 1;
        System.out.println(num);
    }
}
