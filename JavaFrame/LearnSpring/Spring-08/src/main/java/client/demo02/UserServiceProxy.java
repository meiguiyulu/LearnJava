package client.demo02;

/**
 * @author LYJ
 * @create 2021-06-29 14:33
 */
public class UserServiceProxy implements UserService {

    private UserServiceImpl userService;

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }
    @Override
    public void add() {
        log("add");
        System.out.println("增加了一个用户！");
    }

    @Override
    public void delete() {
        log("delete");
        System.out.println("增加了一个用户！");
    }

    @Override
    public void upadte() {
        log("update");
        System.out.println("修改了一个用户！");
    }

    @Override
    public void query() {
        log("query");
        System.out.println("查询了一个用户！");
    }

    public void log(String message){
        System.out.println("使用了" + message + "方法!");
    }

}
