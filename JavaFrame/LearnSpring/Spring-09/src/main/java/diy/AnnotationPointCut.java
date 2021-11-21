package diy;

/**
 * @author LYJ
 * @create 2021-06-29 19:52
 */

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 方式三：使用注解方式实现 AOP
 */
@Aspect // 标注这个类是一个切面
public class AnnotationPointCut {

    @Before("execution(* service.UserServiceImpl.*(..))")
    public void before() {
        System.out.println("=============方法执行前===============");
    }

    @After("execution(* service.UserServiceImpl.*(..))")
    public void after() {
        System.out.println("=============方法执行后===============");
    }

    // 环绕增强中，可以给定一个参数，代表我们要处理切入的点
    @Around("execution(* service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("=============环绕前===============");
        System.out.println("获取签名:\t" + joinPoint.getSignature());
        // 执行方法
        Object proceed = joinPoint.proceed();
        System.out.println("=============环绕后===============");

    }
}
