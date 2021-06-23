package syn;

import java.util.*;

/**
 * @author LYJ
 * @create 2021-04-30 14:58
 * 线程不安全的集合
 */
public class UnSafeList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                synchronized (list){
                    list.add(Thread.currentThread().getName());
                }

            }).start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
        /**
         * list.size()小于10000，原因在于可能有多个线程操作了同一个下标
         */
    }
}
