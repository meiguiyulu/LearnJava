package dao;

import org.apache.ibatis.annotations.*;
import pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author LYJ
 * @create 2021-06-22 16:07
 */
public interface UserMapper {
    /**
     * 得到全部用户
     *
     * @return
     */
    @Select("select * from user")
    List<User> getUsers();

    /**
     * 查找指定用户
     * 方法若存在多个参数，则每个参数之前都必须加上@Param注解，引用类型不用
     *
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
    User getUserByID(@Param("id") int id);

    /**
     * 插入用户
     *
     * @param user
     * @return
     */
    @Insert("insert into user values(#{id}, #{name}, #{pwd})")
    int addUser(User user);

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    @Update("update user set id=#{id}, name=#{name}, pwd=#{pwd} where id=#{id}")
    int updateUser(User user);

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @Delete("delete from user where id = #{uid}")
    int deleteUser(@Param("uid") int id);
}
