package LearnJUC.FunctionInterFace;

import java.util.function.Supplier;

/**
 * @author LYJ
 * @create 2021-05-10 16:39
 * Supplier：供给型接口 没有参数 只要返回值
 */
public class SupplierDemo {
    public static void main(String[] args) {
        /**
         * Supplier<Integer> supplier = new Supplier<Integer>() {
         *             @Override
         *             public Integer get() {
         *                 System.out.println("Get()");
         *                 return 1024;
         *             }
         *         };
         */
        Supplier<Integer> supplier = ()->{
            System.out.println("Get()");
            return 1024;
        };
        System.out.println(supplier.get());
    }
}
