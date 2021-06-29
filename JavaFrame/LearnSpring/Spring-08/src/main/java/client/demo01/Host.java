package client.demo01;

/**
 * @author LYJ
 * @create 2021-06-29 11:09
 */

/**
 * 房东
 */
public class Host implements Rent{

    @Override
    public void rent() {
        System.out.println("房东要出租房子!");
    }
}
