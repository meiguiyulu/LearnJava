package client.demo01;

/**
 * @author LYJ
 * @create 2021-06-29 13:02
 */
public class Proxy implements Rent{

    private Host host;

    public Proxy() {
    }

    public Proxy(Host host) {
        this.host = host;
    }

    @Override
    public void rent() {
        seeHouse();
        host.rent();
        heTong();
        fare();
    }
    /**
     * 看房
     */
    public void seeHouse(){
        System.out.println("中介带你看房!");
    }
    /**
     * 收中介费
     */
    public void fare(){
        System.out.println("收中介费");
    }
    /**
     * 租赁合同
     */
    public void heTong(){
        System.out.println("租赁合同");
    }
}
