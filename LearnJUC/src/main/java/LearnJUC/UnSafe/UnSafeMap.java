package LearnJUC.UnSafe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author LYJ
 * @create 2021-05-06 14:17
 */

/**
 * java.util.ConcurrentModificationException
 *
 * 解决方案:
 *      1. HashTable()
 *      2. Collections.synchronizedMap()
 *      3. Map<String, String> map = new ConcurrentHashMap<>();
 *
 */
public class UnSafeMap {
    public static void main(String[] args) {
        //工作中不用HaseMap
        //默认等价于 new HashMap<>(16, 0.75)
        //Map<String, String> map = new HashMap<>();
        // Collections.synchronizedMap();
        Map<String, String> map = new ConcurrentHashMap<>();
        for (int i=1;i<=100;++i){
            new Thread(()->{
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 5));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }
}
