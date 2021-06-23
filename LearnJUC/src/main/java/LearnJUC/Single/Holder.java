package LearnJUC.Single;

/**
 * @author LYJ
 * @create 2021-05-13 11:36
 * 静态内部类实现单例模式
 */
public class Holder {
    private Holder(){

    }

    public static Holder getInstance(){
        return InnerClass.holder;
    }

    public static class InnerClass{
        private static final Holder holder = new Holder();
    }
}
