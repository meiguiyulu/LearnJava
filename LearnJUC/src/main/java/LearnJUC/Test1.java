package LearnJUC;

/**
 * @author LYJ
 * @create 2021-05-03 15:14
 */
public class Test1 {
    public static void main(String[] args) {
        //获取CPU的核数
        //CPU密集型，IO密集型
        System.out.println(Runtime.getRuntime().availableProcessors());
//        Thread.State;
    }
}
