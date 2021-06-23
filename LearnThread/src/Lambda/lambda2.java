package Lambda;

/**
 * @author LYJ
 * @create 2021-04-29 16:02
 */
public class lambda2 {
    public static void main(String[] args) {
        // lambda表达式简化1 去掉参数类型
        ILove love = (name)->{
            System.out.println("I love " + name);
        };

        // lambda表达式简化2 去掉括号(只有一个参数的时候可以省略括号)
        love = name -> {
            System.out.println("I love " + name);
        };

        // lambda表达式简化3 去掉花括号(只有一行代码的时候可以)
        love = name -> System.out.println("I love " + name);


        love.love("chenxiao");
    }
}

interface ILove{
    void love(String name);
}


