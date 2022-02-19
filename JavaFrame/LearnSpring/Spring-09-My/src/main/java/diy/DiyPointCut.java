package diy;

/**
 * @author LYJ
 * @create 2021-06-29 19:38
 */
public class DiyPointCut {

    public void before() {
        System.out.println("小狗还没开始叫~");
    }

    public void after() {
        System.out.println("小狗不叫了~");
    }

}
