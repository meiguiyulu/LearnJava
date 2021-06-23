package LearnJUC.Counter;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author LYJ
 * @create 2021-05-06 21:38
 */
public class CycleBarrierDemo {
    public static void main(String[] args) {
        /**
         * 集齐7颗龙珠召唤神龙
         */
        CyclicBarrier barrier = new CyclicBarrier(7, ()->{
            System.out.println("召唤神龙成功！");
        });
        for (int i=0;i<7;++i){
            final int temp = i+1;
            //lambda不能操作到i
            /**lambda表达式内部引用的局部变量是隐式的final
             * 只能引用标记了 final 的外层局部变量，这就是说不能在 lambda 内部修改定义在域外的局部变量，否则会编译错误。
             * 局部变量可以不用声明为 final，但是必须不可被后面的代码修改（即隐性的具有 final 的语义）
             * 不允许声明一个与局部变量同名的参数或者局部变量。
             */
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"收集到" + temp + "个龙珠");
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }
}
