package mapper;

import pojo.User;

import java.util.List;

/**
 * @author LYJ
 * @create 2021-06-29 20:30
 */
public interface UserMapper {
    public List<User> queryUsers();

    // 添加一个用户
    public int addUser(User user);

    // 删除一个用户
    public int deleteUser(int id);
}
