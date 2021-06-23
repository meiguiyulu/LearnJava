package LearnJUC.FunctionInterFace;

import java.util.function.Predicate;

/**
 * @author LYJ
 * @create 2021-05-10 16:21
 * 断定型接口：有一个输入参数，返回值是布尔值
 */
public class PredicateDemo {
    public static void main(String[] args) {

        /**|
         * Predicate<String> predicate = new Predicate<String>() {
         *             @Override
         *             public boolean test(String str) {
         *                 // 判断字符串是否为空
         *                 return str.isEmpty();
         *             }
         *         };
         */
        Predicate<String> predicate = (str)->{
            return str.isEmpty();
        };
        System.out.println(predicate.test("abc"));
    }
}
