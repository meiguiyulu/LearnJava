import javax.swing.plaf.TableHeaderUI;

/**
 * @author LYJ
 * @create 2021-04-27 18:57
 */
public class TestTread {
    private int count = 0;

    public synchronized void Plus(){
        count++;
    }
    class PlusClass implements Runnable{
        @Override
        public void run() {
            Plus();
            System.out.println(Thread.currentThread().getName() + "++" + "J: " + count);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void Inc(){
        count--;
    }
    class IncClass implements Runnable{
        @Override
        public void run() {
            Inc();
            System.out.println(Thread.currentThread().getName() + "--" + "J: " + count);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TestTread testTread = new TestTread();
        PlusClass plus = testTread.new PlusClass();
        IncClass inc = testTread.new IncClass();

        for (int i=0;i<10;i++){
            new Thread(plus, "加法").start();
            new Thread(inc, "减法").start();
        }
    }
}
