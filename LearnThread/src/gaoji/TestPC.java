package gaoji;

/**
 * @author LYJ
 * @create 2021-05-03 10:49
 * 测试：生产者消费者模型-->利用缓冲区解决：管程法
 * 生产者，消费者，产品，缓冲区
 */
public class TestPC {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();

        new Productor(container).start();
        new Consumer(container).start();
    }
}

//生产者
class Productor extends Thread{

    SynContainer container;

    public Productor(SynContainer container){
        this.container = container;
    }

    @Override
    public void run() {
        for (int i=1;i<=100;i++){
            System.out.println("生产了---->id为" + i + "的鸡");
            container.push(new Chicken(i));
        }
    }
}

//消费者
class Consumer extends Thread{
    SynContainer container;
    public Consumer(SynContainer container){
        this.container = container;
    }

    @Override
    public void run() {
        for (int i=1;i<=100;i++){
            System.out.println("消费了---->id为" + container.pop().id + "的鸡");
        }
    }
}


//产品
class Chicken{
    int id; //产品编号
    public Chicken(int id){
        this.id = id;
    }
}

//缓冲区
class SynContainer{
    //容器大小
    Chicken[] chickens = new Chicken[10];
    int count = 0;//容器计数器

    //生产者放入产品
    public synchronized void push(Chicken chicken){
        //如果容器满了，就需要消费者消费
        if (count==chickens.length){
            //容器满了：通知生产者消费；生产者等待。
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //如果容器没有满，生产者可以丢入产品
        chickens[count] = chicken;
        count++;
        //通知消费者消费
        this.notifyAll();
    }

    //消费者消费产品
    public synchronized Chicken pop(){
        //判断容器满不满(能否可以消费)
        if (count==0){
            //等待生产者生产，消费者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果可以消费
        count--;
        Chicken chicken = chickens[count];

        //消费了，通知生产者生产
        this.notifyAll();
        return chicken;
    }
}

