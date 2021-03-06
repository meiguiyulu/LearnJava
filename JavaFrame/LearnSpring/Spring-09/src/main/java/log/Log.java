package log;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author LYJ
 * @create 2021-06-29 17:20
 */
public class Log implements MethodBeforeAdvice {

    /**
     * @param method  要执行的目标对象的方法
     * @param objects 参数
     * @param o       目标对象
     */
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println(o.getClass().getName() + "的" + method.getName() + "被执行了");
    }
}
