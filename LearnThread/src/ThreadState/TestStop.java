package ThreadState;

/**
 * @author LYJ
 * @create 2021-04-29 19:29
 * //线程停止
 * 1. 建议线程正常停止--->利用次数，不建议死循环；
 * 2. 建议使用标志位--->设置一个标志位
 * 3. 不要使用stop或者destroy等过时或者JDK不建议使用的方法
 */
public class TestStop implements Runnable {
    // 第一步：设置一个标志位
    private boolean flag = true;
    private static int i=0;
    @Override
    public void run() {
        while (flag){
            System.out.println("run......Thread"+i++);
        }
    }
    //设置一个公开的方法停止线程，转换标志位
    public void stop(){
        this.flag = false;
    }

    public static void main(String[] args) {
        TestStop stop = new TestStop();
        new Thread(stop).start();
        for (int i=0;i<1000;i++){
            System.out.println("main" + i);
            if (i==900){
                //调用自己写的stop方法切换标志位，让线程停止。
                stop.stop();
                System.out.println("线程停止~");
            }
        }
    }
}
