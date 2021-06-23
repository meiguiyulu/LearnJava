package ThreadState;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author LYJ
 * @create 2021-04-29 20:06
 * 模拟倒计时
 */
public class TestSleep2 {

    public static void main(String[] args) {
//        try {
//            TenDown();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //打印系统当前时间
        Date startTime = new Date(System.currentTimeMillis());//获取系统当前时间

        while (true){
            try {
                System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startTime));
                Thread.sleep(1000);
                startTime = new Date(System.currentTimeMillis());//更新时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //模拟倒计时
    public static void TenDown() throws InterruptedException {
        int num = 10;
        while (true){
            Thread.sleep(1000);
            System.out.println(num--);
            if (num<=0)
                break;
        }
    }

}
