package DeadLock;

/**
 * @author LYJ
 * @create 2021-04-30 16:15
 * 死锁：多个线程互相抱着对方需要的资源，然后形成僵持
 */
public class DeadLock {
    public static void main(String[] args) {
        Makeup gril1 = new Makeup(0, "灰姑娘");
        Makeup gril2 = new Makeup(1, "白雪公主");

        gril1.start();
        gril2.start();
    }
}

//口号
class Lipstick{

}

//镜子
class Mirror{

}

// 化妆
class Makeup extends Thread{

    //需要的资源只有一份，用static保证
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    int choice; //选择
    String girl;//使用换妆品的人

    Makeup(int choice, String girl){
        this.choice = choice;
        this.girl = girl;
    }

    //化妆，互相持有对方的锁，需要拿到对方的锁
    private void makeup(){
        if (choice==0){
            synchronized (lipstick){ //口红的锁
                System.out.println(this.girl + "获得了口红");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (mirror){//镜子的锁
                    System.out.println(this.girl + "获得了镜子");
                }
            }
        }
        else {
            synchronized (mirror){ //镜子的锁
                System.out.println(this.girl + "获得了镜子");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lipstick){//口红的锁
                    System.out.println(this.girl + "获得了口红");
                }
            }
        }
    }

    @Override
    public void run() {
        makeup();
    }
}

/**
 * 下面代码没有死锁，因为是先释放锁以后再加锁
 * if (choice==0){
 *             synchronized (lipstick){ //口红的锁
 *                 System.out.println(this.girl + "获得了口红");
 *                 try {
 *                     Thread.sleep(1000);
 *                 } catch (InterruptedException e) {
 *                     e.printStackTrace();
 *                 }
 *             }
 *             synchronized (mirror){//镜子的锁
 *  *                     System.out.println(this.girl + "获得了镜子");
 *  *                 }
 *         }
 *         else {
 *             synchronized (mirror){ //镜子的锁
 *                 System.out.println(this.girl + "获得了镜子");
 *                 try {
 *                     Thread.sleep(1000);
 *                 } catch (InterruptedException e) {
 *                     e.printStackTrace();
 *                 }
 *
 *             }
 *              synchronized (lipstick){//口红的锁
 *  *                     System.out.println(this.girl + "获得了口红");
 *  *                 }
 *         }
 */
