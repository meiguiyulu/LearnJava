package LearnJUC.Single;

/**
 * @author LYJ
 * @create 2021-05-13 11:15
 * 饿汉式单例  直接创建单例  浪费空间
 */
public class Hungry {
    private Hungry(){
    }

    private final static Hungry hungry = new Hungry();

    public static Hungry getInstance(){
        return hungry;
    }

}
