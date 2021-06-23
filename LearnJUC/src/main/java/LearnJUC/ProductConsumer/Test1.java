package LearnJUC.ProductConsumer;

/**
 * @author LYJ
 * @create 2021-05-04 10:17
 * 线程之间的通信问题：生产者消费者问题
 * 线程交替执行 ： 两个线程 A、B操作同一个变量
 */
public class Test1 {
    public static void main(String[] args) {
        Data data = new Data();

        new Thread(()->{
            for (int i=0;i<10;i++){
                data.Increment();
            }
        }, "A").start();
        new Thread(()->{
            for (int i=0;i<10;i++){
                data.Decrement();
            }
        }, "B").start();

        new Thread(()->{
            for (int i=0;i<10;i++){
                data.Increment();
            }
        }, "C").start();

        new Thread(()->{
            for (int i=0;i<10;i++){
                data.Decrement();
            }
        }, "D").start();

    }
}

//判断等待，业务，通知
class Data{
    private int number = 0;

    //+1
    public synchronized void Increment(){
        while (number!=0){
            //等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ++number;
        System.out.println(Thread.currentThread().getName() + "=>" + number);
        //通知其他线程，我+1完毕
        this.notifyAll();
    }

    //-1
    public synchronized void Decrement(){
        while (number==0){
            //等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        --number;
        System.out.println(Thread.currentThread().getName() + "=>" + number);
        //通知其他线程，我-1完毕
        this.notifyAll();
    }
}

