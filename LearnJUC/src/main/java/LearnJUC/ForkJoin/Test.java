package LearnJUC.ForkJoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * @author LYJ
 * @create 2021-05-12 16:45
 */
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Test1(); //5754ms
//        Test2(); // 1148ms
        Test3(); // 169ms
    }

    // 普通程序员
    public static void Test1(){
        Long sum = 0L;
        Long start = System.currentTimeMillis();
        for (Long i=1L;i<=10_0000_0000;++i){
            sum = sum + i;
        }
        Long end = System.currentTimeMillis();
        System.out.println("sum=" + sum + "\tTime:" + (end-start));
    }
    // 会使用ForkJoin
    public static void Test2() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();

        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinDemo(0L, 10_0000_0000L);
        ForkJoinTask<Long> submit = pool.submit(task); // 提交任务
        Long sum = submit.get();

        long end = System.currentTimeMillis();
        System.out.println("sum=" + sum + "\tTime:" + (end-start));
    }

    // 使用Stream并行流
    public static void Test3(){
        long start = System.currentTimeMillis();

        /**
         * IntStream
         * DoubleStream
         */
        long sum = LongStream.rangeClosed(0L, 10_0000_0000L).parallel().reduce(0, Long::sum);

        long end = System.currentTimeMillis();
        System.out.println("sum=" + sum + "\tTime:" + (end-start));
    }

}
