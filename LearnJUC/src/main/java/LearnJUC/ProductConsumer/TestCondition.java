package LearnJUC.ProductConsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LYJ
 * @create 2021-05-04 13:18
 * A执行完调用B，B执行完调用C，C执行完调用A
 */
public class TestCondition {
    public static void main(String[] args) {

        Resource resource = new Resource();

        new Thread(()->{
            for (int i=0;i<10;i++)
                resource.PrintA();
            }, "A").start();

        new Thread(()->{
            for (int i=0;i<10;i++)
                resource.PrintB();
            }, "B").start();

        new Thread(()->{
            for (int i=0;i<10;i++)
                resource.PrintC();
            }, "C").start();
    }
}

class Resource{
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();
    private int number = 1;

    public void PrintA(){
        lock.lock();
        try {
            //业务代码
            while (number!=1){
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName() + "=>AAA");
            //唤醒指定的对象
            number = 2;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void PrintB(){
        lock.lock();
        try {
            //业务代码
            while (number!=2){
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName() + "=>BBB");
            number = 3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void PrintC(){
        lock.lock();
        try {
            //业务代码
            while (number!=3){
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName() + "=>CCC");
            number = 1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
