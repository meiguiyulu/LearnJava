package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

// 获取类的信息
public class Test7 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {

        Class c1 = Class.forName("Reflection.User");

        User user = new User();
        Class c2 = user.getClass();

        // 获取类的名字
                // 包名 + 类名
        System.out.println(c1.getName());
                // 类名
        System.out.println(c1.getSimpleName());

        System.out.println(c2.getSimpleName());
        System.out.println(c2.getName());
        System.out.println("========================================");
        // 获取类的属性
        Field[] fields = c1.getFields(); // 只能找到public属性
        for (Field field: fields){
            System.out.println(field);
        }

        fields = c1.getDeclaredFields(); // 找到全部的属性
        for (Field field:fields){
            System.out.println(field);
        }

        // 获得指定属性的值
        Field name = c1.getDeclaredField("name");
        System.out.println(name);

        System.out.println("===================================");
        //获得类的方法
        Method[] methods = c1.getMethods(); // 获得本类及其父类的全部public方法
        for (Method method: methods){
            System.out.println("getMethods:\t" + method);
        }
        methods = c1.getDeclaredMethods();  //获得本类的所有方法
        for (Method method: methods){
            System.out.println("getDeclaredMethods:\t" + method);
        }
        // 获得指定方法
        Method getName = c1.getMethod("getName", null);
        Method setName = c1.getMethod("setName", String.class);
        System.out.println(getName);
        System.out.println(setName);

        System.out.println("===================================");
        // 获取指定的构造器
        Constructor[] constructors = c1.getConstructors(); // 只能获取public的构造方法
        for (Constructor constructor : constructors){
            System.out.println(constructor);
        }
        constructors = c1.getDeclaredConstructors(); // 获取所有的构造方法
        for (Constructor constructor : constructors){
            System.out.println(constructor);
        }

        // 获取指定的构造器
        Constructor getDeclaredConstructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        System.out.println("指定:\t" + getDeclaredConstructor);

    }
}
