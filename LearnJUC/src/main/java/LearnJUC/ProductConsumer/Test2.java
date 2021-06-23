package LearnJUC.ProductConsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LYJ
 * @create 2021-05-04 11:10
 */
public class Test2 {
    public static void main(String[] args) {
        Data2 data = new Data2();

        new Thread(()->{
            for (int i=0;i<10;i++){
                data.Increment();
            }
        }, "A").start();

        new Thread(()->{
            for (int i=0;i<10;i++){
                data.Decrement();
            }
        }, "B").start();

        new Thread(()->{
            for (int i=0;i<10;i++){
                data.Increment();
            }
        }, "C").start();

        new Thread(()->{
            for (int i=0;i<10;i++){
                data.Decrement();
            }
        }, "D").start();

    }
}

//判断等待，业务，通知
class Data2{
    private int number = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

//    condition.await();//等待
//    condition.signalAll();//唤醒全部

    //+1
    public void Increment(){
        lock.lock();
        try {
            //业务代码
            while (number!=0){
                //等待
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            ++number;
            System.out.println(Thread.currentThread().getName() + "=>" + number);
            //通知其他线程，我+1完毕
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
         lock.unlock();
        }
    }

    //-1
    public void Decrement(){
        lock.lock();
        try {
            while (number==0){
                //等待
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            --number;
            System.out.println(Thread.currentThread().getName() + "=>" + number);
            //通知其他线程，我-1完毕
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

