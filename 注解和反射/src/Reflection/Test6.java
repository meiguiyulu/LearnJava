package Reflection;

public class Test6 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        // 获取系统类加载器的父类加载器-->扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        // 或者扩展类加载器的父类加载器-->根加载器(c/c++)
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        // 测试当前类是哪个加载器加载的
        ClassLoader classLoader = Class.forName("Reflection.Test6").getClassLoader();
        System.out.println(classLoader);

        /**
         *输出为null
         * 因为JDK中的类是由跟加载器加载的(无法直接获取)
         */
        classLoader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader);

        // 如何获取系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));
    }
}
