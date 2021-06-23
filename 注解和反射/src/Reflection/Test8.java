package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// 通过反射动态的创建对象
public class Test8 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        // 获得Class对象
        Class c1 = Class.forName("Reflection.User");

        // 创建一个对象
        User user = (User) c1.getDeclaredConstructor().newInstance(); // 调用了类的无参构造器
        System.out.println(user);
        System.out.println("======================================");

        // 通过构造器创建一个对象
        Constructor declaredConstructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        User yxj = (User) declaredConstructor.newInstance("yxj", 1, 23);
        System.out.println(yxj);
        System.out.println("======================================");

        // 通过反射调用普通构造方法
            // invoke(对象, "方法的值") 激活
        User user2 = (User) c1.getDeclaredConstructor().newInstance();
        Method setName = c1.getMethod("setName", String.class);
        setName.invoke(user2, "刘云杰");
        System.out.println(user2.getName());
        System.out.println("======================================");

        // 通过反射操作属性
        User user3 = (User) c1.getDeclaredConstructor().newInstance();
        Field name = c1.getDeclaredField("name");
        name.setAccessible(true); // 设置可访问(给私有对象赋予操作权限)
        /**
         * 不能直接操作私有属性
         * 需要关闭安全检测
         * 属性或者方法的setAccessible(true)
         */
        name.set(user3, "云小杰");
        System.out.println(user3.getName());
        System.out.println("======================================");


    }
}