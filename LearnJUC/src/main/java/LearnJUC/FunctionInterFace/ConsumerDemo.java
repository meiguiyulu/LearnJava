package LearnJUC.FunctionInterFace;

import java.util.function.Consumer;

/**
 * @author LYJ
 * @create 2021-05-10 16:33
 * Consumer 消费型接口：只要输入，没有返回值。
 */
public class ConsumerDemo {
    public static void main(String[] args) {
        /**
         * Consumer<String> consumer = new Consumer<String>() {
         *             @Override
         *             public void accept(String o) {
         *                 System.out.println(o);
         *             }
         *         };
         */
        Consumer<String> consumer = (str)->{
            System.out.println(str);
        };

        consumer.accept("abc");
    }
}
