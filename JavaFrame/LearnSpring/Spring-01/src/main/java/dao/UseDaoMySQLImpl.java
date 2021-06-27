package dao;

/**
 * @author LYJ
 * @create 2021-06-26 14:36
 */
public class UseDaoMySQLImpl implements UseDao{

    @Override
    public void getUser() {
        System.out.println("MySQL获取用户的数据!");
    }
}
