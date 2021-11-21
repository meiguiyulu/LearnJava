package dao;

import pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author LYJ
 * @create 2021-06-22 16:07
 */
public interface UserMapper {

    List<User> getUserLike(String str);


    /**
     * 查询全部用户
     *
     * @return
     */
    List<User> getUserList();

    /**
     * 根据id查询用户
     */
    User getUserById(int id);

    User searchUser(Map<String, Object> map);


    /**
     * 插入用户
     *
     * @param user
     * @return
     */
    int AddUser(User user);

    /**
     * 万能的Map
     *
     * @param map
     * @return
     */
    int InsertUser(Map<String, Object> map);


    /**
     * 修改用户
     *
     * @param user
     * @return
     */
    int UpdateUser(User user);

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    int deleteUser(int id);

}
