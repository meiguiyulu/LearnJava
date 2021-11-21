package client.demo02;

/**
 * @author LYJ
 * @create 2021-06-29 14:26
 */
public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("增加了一个用户！");
    }

    @Override
    public void delete() {
        System.out.println("增加了一个用户！");
    }

    @Override
    public void upadte() {
        System.out.println("修改了一个用户！");
    }

    @Override
    public void query() {
        System.out.println("查询了一个用户！");
    }
}
