package service;

/**
 * @author LYJ
 * @create 2021-06-29 17:13
 */
public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("添加用户");
    }

    @Override
    public void delete() {
        System.out.println("删除用户");
    }

    @Override
    public void update() {
        System.out.println("更新用户信息");
    }

    @Override
    public void select() {
        System.out.println("查询用户");
    }
}
