package dao;

import org.apache.ibatis.annotations.Param;
import pojo.Teacher;

import java.util.List;

/**
 * @author LYJ
 * @create 2021-06-23 19:33
 */
public interface TeacherMapper {
    List<Teacher> getTeachers();

    /**
     * 获取指定老师的信息及老师的学生
     */
    Teacher getTeacher(@Param("tid") int id);

    Teacher getTeacher2(@Param("tid") int id);
}
