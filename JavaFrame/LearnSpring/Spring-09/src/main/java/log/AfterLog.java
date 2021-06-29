package log;

import org.springframework.aop.AfterAdvice;
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author LYJ
 * @create 2021-06-29 17:24
 */
public class AfterLog implements AfterReturningAdvice {

    // returnValue返回值
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("执行了" + method.getName() + "\t返回了" + returnValue);
    }
}
