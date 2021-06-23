package Annotation;


import java.lang.annotation.*;

/**
 * @author LYJ
 * @create 2021-05-30 19:43
 * 测试元注解
 */
public class Test2 {
    @MyAnnotation
    public void test(){
    }
}

/**
 * @author LYJ
 */
// 定义一个注解  @ Target表明注解的使用范围
@Target(value = {ElementType.METHOD, ElementType.TYPE})
// @Retention表示注解在什么地方有效，如RUNTIME运行时有效
// RUNTIME>CLASS>SOURCE
@Retention(value = RetentionPolicy.RUNTIME)
// @Documented 表示是否将我们的注解生成在JAVAdoc中
@Documented
// @Inherited 子类可以继承父类的注解
@Inherited
@interface MyAnnotation {

}
