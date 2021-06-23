package Lambda;

/**
 * @author LYJ
 * @create 2021-04-28 22:01
 * 推到lambda表达式
 */
public class TestLambda1 {

    // 3. 静态内部类
    static class Like2 implements ILike{
        @Override
        public void lambda() {
            System.out.println("静态内部类\tI Like lambda");
        }
    }

    public static void main(String[] args) {
        ILike like = new Like();
        like.lambda();

        like = new Like2();
        like.lambda();

        //4. 局部内部类
        class Like3 implements ILike{
            @Override
            public void lambda() {
                System.out.println("局部内部类\tI Like lambda");
            }
        }

        like = new Like3();
        like.lambda();

        //5. 匿名内部类：没有类的名称，必须借助接口或者父类
        like = new ILike() {
            @Override
            public void lambda() {
                System.out.println("匿名内部类\tI Like Lambda");
            }
        };
        like.lambda();

        // 6. 用lambda简化
        like = ()->{
            System.out.println("lambda简化\tI Like Lambda");
        };
        like.lambda();
    }
}
// 1. 定义一个函数式接口
interface ILike{
    void lambda();
}

// 2. 实现类
class Like implements ILike{
    @Override
    public void lambda() {
        System.out.println("I Like lambda");
    }
}
