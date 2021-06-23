package Reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// 分析性能问题
public class Test9 {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        test1();
        test2();
        test3();

    }
    // 普通方法调用
    public static void test1(){
        User user = new User();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; ++i){
            user.getName();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("普通方法执行10亿次：" + (endTime-startTime)+"ms");
    }
    // 反射方法调用
    public static void test2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        Class c = user.getClass();

        Method method = c.getDeclaredMethod("getName", null);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; ++i){
            method.invoke(user, null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("反射方法执行10亿次：" + (endTime-startTime)+"ms");
    }

    // 反射方法调用 关闭检测
    public static void test3() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        Class c = user.getClass();

        Method method = c.getDeclaredMethod("getName", null);
        method.setAccessible(true);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; ++i){
            method.invoke(user, null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("反射方法 关闭检测执行10亿次：" + (endTime-startTime)+"ms");
    }
}
