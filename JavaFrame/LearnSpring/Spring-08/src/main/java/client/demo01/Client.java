package client.demo01;

/**
 * @author LYJ
 * @create 2021-06-29 13:01
 */
public class Client {
    public static void main(String[] args) {
        // 房东要租房子
        Host host = new Host();
        // 代理,中介帮房东租房子，但是代理会有一些附属操作
        Proxy proxy = new Proxy(host);
        // 去找中介租房
        proxy.rent();
    }
}
