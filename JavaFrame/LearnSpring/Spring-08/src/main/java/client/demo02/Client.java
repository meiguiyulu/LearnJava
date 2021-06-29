package client.demo02;

/**
 * @author LYJ
 * @create 2021-06-29 14:27
 */
public class Client {
    public static void main(String[] args) {
        UserServiceImpl service = new UserServiceImpl();

        UserServiceProxy proxy = new UserServiceProxy();
        proxy.setUserService(service);
        proxy.add();
        proxy.delete();
        proxy.upadte();
        proxy.query();
    }
}
