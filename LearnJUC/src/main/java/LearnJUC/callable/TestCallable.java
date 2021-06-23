package LearnJUC.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author LYJ
 * @create 2021-05-06 20:56
 */
public class TestCallable {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        FutureTask futureTask = new FutureTask(thread);
        new Thread(futureTask, "A").start();
        try {
            Integer o = (Integer) futureTask.get(); //获取Callable的返回结果
            System.out.println(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("callable()");
        return 1024;
    }
}
