import javax.swing.plaf.TableHeaderUI;

/**
 * @author LYJ
 * @create 2021-04-28 20:57
 */
//模拟龟兔赛跑
public class Race implements Runnable{

    //胜利者
    private static String winner;

    @Override
    public void run() {
        for (int i=1;i<=100;i++){

            //模拟兔子休息
            if (Thread.currentThread().getName().equals("兔子") && (i%20==0)){
                try {
                    System.out.println(Thread.currentThread().getName() + "睡觉了!");
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            boolean flag = gameOver(i); //判断比赛是否结束
            if (flag) //如果比赛结束了，就停止程序
                break;

            System.out.println(Thread.currentThread().getName() + "-->跑了" + i + "步");
        }
    }

    //判断是否完成比赛
    private boolean gameOver(int steps){
        if (winner!=null){ //已经存在胜利者了
            return true;
        }
        else {
            if (steps>=100){
                winner = Thread.currentThread().getName();
                System.out.println("Winner is " + winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();

        new Thread(race, "兔子").start();
        new Thread(race, "乌龟").start();
    }
}
