package syn;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author LYJ
 * @create 2021-04-30 15:38
 * 测试JUC安全类型的集合 list线程不安全，CopyOnWriteArrayList线程安全
 */
public class TestJUC {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String > list = new CopyOnWriteArrayList<String >();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
