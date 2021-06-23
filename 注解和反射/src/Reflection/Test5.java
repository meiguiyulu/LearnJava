package Reflection;

/**
 * @author LYJ
 * @create 2021-05-31 21:13
 * 测试类什么时候初始化
 */
public class Test5 {
    static {
        System.out.println("Main类被加载");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        // 1. 主动引用
        // Son son = new Son();
        /**
         * 输出：
         * Main类被加载
         * 父类被加载
         * 子类被加载
         */

        // 2. 反射也会产生主动引用
        // Class.forName("Reflection.Son");
        /**
         * 输出：
         * Main类被加载
         * 父类被加载
         * 子类被加载
         */

        // 不会产生类的引用的方法
        // System.out.println(Son.b);
        /**
         * 输出：
         * Main类被加载
         * 父类被加载
         * 2
         */

        // Son[] arr = new Son[5];
        /**
         * 输出：
         * Main类被加载
         */

        System.out.println(Son.M);
        /**
         * 输出：
         * Main类被加载
         * 1
         */
    }
}

class Father{
    static int b = 2;
    static {
        System.out.println("父类被加载");
    }
}

class Son extends Father{
    static {
        System.out.println("子类被加载");
        m = 300;
    }
    static int m = 100;
    static final int M = 1;
}