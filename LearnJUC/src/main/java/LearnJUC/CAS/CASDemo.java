package LearnJUC.CAS;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author LYJ
 * @create 2021-05-13 11:53
 */
public class CASDemo {

    /**
     * CAS CompareAndSwap 比较并交换
     *
     */

    public static void main(String[] args) {
        AtomicInteger atomic = new AtomicInteger(2020);

        // public final boolean compareAndSet(int expectedValue, int newValue)
        // 如果期望的值达到了，那么就更新；否则，不更新
        System.out.println(atomic.compareAndSet(2020, 2021));
        System.out.println(atomic.get());

        atomic.getAndIncrement();

        System.out.println(atomic.compareAndSet(2020, 2021));
        System.out.println(atomic.get());
    }
}
