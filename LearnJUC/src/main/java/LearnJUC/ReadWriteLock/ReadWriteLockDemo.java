package LearnJUC.ReadWriteLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author LYJ
 * @create 2021-05-07 19:44
 *
 * * 独占锁（写锁） 一次只能被一个线程占有
 * * 共享锁（读锁） 多个线程可以同时占有
 *
 * ReadWriteLock
 * * 读-读 可以共存！
 * * 读-写 不能共存！
 * * 写-写 不能共存！
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
//        MyCache cache = new MyCache();
        MyCacheLock cache = new MyCacheLock();

        //写入
        for (int i = 0; i < 5; i++) {
            final int temp = i+1;
            new Thread(()->{
                cache.put(String.valueOf(temp), temp);
            }, String.valueOf(i+1)).start();
        }

        //读取
        for (int i = 0; i < 5; i++) {
            final int temp = i+1;
            new Thread(()->{
                cache.get(String.valueOf(temp));
            }, String.valueOf(i+1)).start();
        }
    }
}

/**
 * 自定义缓存
 */
// 无锁的
class MyCache{
    private volatile Map<String, Object> map = new HashMap<>();

    //存 (写)
    public void put(String key, Object value){
        System.out.println(Thread.currentThread().getName() + "写入" + key);
        map.put(key, value);
        System.out.println(Thread.currentThread().getName() + "写入成功");
    }
    //取 (读)
    public void get(String key){
        System.out.println(Thread.currentThread().getName() + "读取" + key);
        Object o = map.get(key);
        System.out.println(Thread.currentThread().getName() + "读取完成");
    }

}

// 加锁的
class MyCacheLock{
    private volatile Map<String, Object> map = new HashMap<>();
    private ReadWriteLock lock = new ReentrantReadWriteLock(); // 读写锁：更加细粒度的控制

    // 写入的时候，希望只有一个线程
    public void put(String key, Object value){
        lock.writeLock().lock(); // 写锁

        try {
            System.out.println(Thread.currentThread().getName() + "写入" + key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "写入成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }
    // 读的时候，所有人都可以读
    public void get(String key){
        lock.readLock().lock();

        try {
            System.out.println(Thread.currentThread().getName() + "读取" + key);
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName() + "读取完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }

    }

}
