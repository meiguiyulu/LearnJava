package ThreadState;

/**
 * @author LYJ
 * @create 2021-04-29 20:44
 * 测试Join方法，想象为插队
 */
public class TestJoin implements Runnable{
    @Override
    public void run() {
        for (int i=0;i<1000;i++){
            System.out.println("线程vip来了" + i);
        }
    }

    public static void main(String[] args) {
        //启动线程
        TestJoin join = new TestJoin();
        Thread thread = new Thread(join);
        thread.start();

        //线程
        for (int i=0;i<1000;i++){
            if (i==200){
                try {
                    thread.join(); //插队
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("主线程执行：" + i);
        }
    }
}
