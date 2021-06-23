package LearnJUC.FunctionInterFace;

import java.util.function.Function;

/**
 * @author LYJ
 * @create 2021-05-10 16:07
 * Function函数式接口 有一个输入参数，有一个输出
 * 只要是函数式接口，就可以用lambda表达式简化
 */
public class FunctionDemo {
    public static void main(String[] args) {

        /**
         *         Function function = new Function<String, String>() {
         *             @Override
         *             public String apply(String str) {
         *                 return str;
         *             }
         *         };
         */
        Function function = (str)->{return str;};
        System.out.println(function.apply("abc"));
    }
}
