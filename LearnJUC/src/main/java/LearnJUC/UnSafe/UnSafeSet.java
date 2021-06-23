package LearnJUC.UnSafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author LYJ
 * @create 2021-05-06 13:49
 */

/**
 * java.util.ConcurrentModificationException
 * 解决方案:
 *      1. Collections.synchronizedSet()  通过工具类转化为synchronized
 *              Set<String> set = Collections.synchronizedSet(new HashSet<>());
 *      2. CopyOnWriteArraySet  写入时复制
 *              Set<String> set = new CopyOnWriteArraySet<>();
 *
 */
public class UnSafeSet {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        // Set<String> set = Collections.synchronizedSet(new HashSet<>());
        // Set<String> set = new CopyOnWriteArraySet<>();

        for (int i=1;i<=100;++i){
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }
}
