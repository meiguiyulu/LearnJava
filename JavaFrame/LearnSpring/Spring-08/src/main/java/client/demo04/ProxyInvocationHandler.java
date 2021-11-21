package client.demo04;

import client.demo03.Rent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author LYJ
 * @create 2021-06-29 15:19
 */

/**
 * 用这个类自动生成代理类
 *
 * @author LYJ
 */
public class ProxyInvocationHandler implements InvocationHandler {

    // 被代理的接口
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }


    /**
     * 得到代理类
     */
    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    /**
     * 处理代理实例，并返回结果
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        log(method.getName());
        // 动态代理的本质是使用反射机制实现!
        Object invoke = method.invoke(target, args);
        return invoke;
    }

    public void log(String msg) {
        System.out.println("执行了" + msg + "方法");
    }

}
