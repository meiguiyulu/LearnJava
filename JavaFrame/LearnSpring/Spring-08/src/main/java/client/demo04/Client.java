package client.demo04;

import client.demo02.UserService;
import client.demo02.UserServiceImpl;

/**
 * @author LYJ
 * @create 2021-06-29 16:14
 */
public class Client {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();

        ProxyInvocationHandler handler = new ProxyInvocationHandler();
        handler.setTarget(userService);
        UserService proxy = (UserService) handler.getProxy();
        proxy.query();
    }
}
