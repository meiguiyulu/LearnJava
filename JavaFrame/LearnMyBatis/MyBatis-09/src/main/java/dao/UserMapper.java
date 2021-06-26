package dao;

import org.apache.ibatis.annotations.Param;
import pojo.User;

/**
 * @author LYJ
 * @create 2021-06-26 9:54
 */
public interface UserMapper {

    User queryUserById(@Param("id") int id);

    int updateUser(User user);


}
