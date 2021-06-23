package LearnJUC.ForkJoin;

import java.util.concurrent.RecursiveTask;

/**
 * @author LYJ
 * @create 2021-05-10 21:29
 * 求和计算的任务
 * 如何使用ForkJoin
 * 1. ForkJoinPool执行
 * 2. 计算任务 ForkJoinPool.execute(ForkJoinTask<?> task)
 * 3. 计算类继承 ForkJoinTask
 */
public class ForkJoinDemo extends RecursiveTask<Long> {

    private long start;
    private long end;
    //临界值
    private long temp = 10000L;

    public ForkJoinDemo(long start, long end){
        this.start = start;
        this.end = end;
    }

    public void Calculate(){
        if ((end-start)>temp){
            // 分治合并的思想
        } else {
            long sum = 0;
            for (long i = start;  i <= end; ++i) {
                sum += i;
            }
            System.out.println(sum);
        }
    }


    public static void main(String[] args) {
        /**
         * for (int i = 1; i <= 10_0000_0000; i++) {
         *     ans += i;
         *  }
         */

    }

    // ForkJoin的计算方法
    @Override
    protected Long compute() {
        if ((end-start)<temp){
            long sum = 0;
            for (long i = start;  i <= end; ++i) {
                sum += i;
            }
            System.out.println(sum);
            return sum;
        }
        else { // ForkJoin
            long mid = start + (end - start) / 2; // 中间值
            ForkJoinDemo task1 = new ForkJoinDemo(start, mid);
            task1.fork(); // 拆分任务，把任务压入线程队列
            ForkJoinDemo task2 = new ForkJoinDemo(mid+1, end);
            task2.fork();

            return task1.join() + task2.join();
        }
    }
}
