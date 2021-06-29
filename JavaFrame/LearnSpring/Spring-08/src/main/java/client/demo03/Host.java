package client.demo03;

/**
 * @author LYJ
 * @create 2021-06-29 15:17
 */
public class Host implements Rent{

    @Override
    public void rent() {
        System.out.println("房东要出租房子!");
    }
}
