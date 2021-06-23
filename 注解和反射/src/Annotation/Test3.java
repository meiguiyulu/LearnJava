package Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author LYJ
 * @create 2021-05-30 20:33
 * 自定义注解
 */
public class Test3 {

    // 注解必须赋值，如果没有默认值，就必须给注解赋值
    @MyAnnotation2(name = "云小杰")
    public void test(){

    }

    @MyAnnotation3("云小杰")
    public void test2(){}
}

/**
 * @author LYJ
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2{
    // 注解的参数：参数类型 + 参数名 + ();
    String name() default "";
    int age() default 0;
    int id() default -1; // 如果默认值是-1，代表不存在

    String[] schools() default {"吉大", "延大"};
}

/**
 * @author LYJ
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation3{
    String value();
}
