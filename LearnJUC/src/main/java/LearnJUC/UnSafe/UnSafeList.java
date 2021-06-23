package LearnJUC.UnSafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author LYJ
 * @create 2021-05-06 10:42
 */

/**
 * java.util.ConcurrentModificationException 并发修改异常
 * 并发下ArrayList是不安全的
 * 解决方案:
 *         1. List<String> list = new Vector<>(); (Vector使用了synchronized)
 *         2. List<String> list = Collections.synchronizedList(new ArrayList<>());
 *         3. List<String> list = new CopyOnWriteArrayList<>();
 */

public class UnSafeList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        new Vector<>();
//        Collections.synchronizedList();
//        new CopyOnWriteArrayList<>();
        for (int i=1;i<=50;i++){
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
