package LearnJUC.CAS;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author LYJ
 * @create 2021-05-13 17:31
 */
public class CASABA {
    public static void main(String[] args) {

        AtomicInteger atomic = new AtomicInteger(2020);

        // 捣乱的线程
        System.out.println(atomic.compareAndSet(2020, 2021));
        System.out.println(atomic.get());
        System.out.println(atomic.compareAndSet(2021, 2020));
        System.out.println(atomic.get());

        // 期望的线程
        System.out.println(atomic.compareAndSet(2020, 2022));
        System.out.println(atomic.get());
    }
}
