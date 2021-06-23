package dao;

import pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author LYJ
 * @create 2021-06-22 16:07
 */
public interface UserMapper {

    /**
     * 根据id查询用户
     */
    User getUserById(int id);


}
