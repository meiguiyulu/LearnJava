package LearnJUC.Single;

/**
 * @author LYJ
 * @create 2021-05-13 11:28
 * 懒汉式单例
 */
public class Lazy {
    private Lazy(){

    }
    private volatile static Lazy lazy;

    // 双重检测锁模式的单例 简称DCL懒汉式
    public static Lazy getInstance(){
        if (lazy==null){
            synchronized (Lazy.class){
                if (lazy == null) {
                    lazy = new Lazy(); // 不是原子性操作
                }
            }
        }
        return lazy;
    }
    // 单线程下这样代码是安全的，多线程下不安全
    /**
     *      单线程下这样代码是安全的，多线程下不安全
     *     public static Lazy getInstance(){
     *         if (lazy==null){
     *             lazy = new Lazy();
     *         }
     *         return lazy;
     *     }
     */
}
