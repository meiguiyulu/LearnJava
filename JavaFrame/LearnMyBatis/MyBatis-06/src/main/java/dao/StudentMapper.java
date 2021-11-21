package dao;

import pojo.Student;
import pojo.Teacher;

import java.util.List;

/**
 * @author LYJ
 * @create 2021-06-23 19:32
 */
public interface StudentMapper {

    /**
     * 查询所有的学生的学生信息，以及对应的老师信息
     * select
     * s.id, s.name, t.name
     * from
     * student as s, teacher as t
     * where
     * s.tid=t.id;
     */
    public List<Student> getStudent();

    public List<Student> getStudent2();

}
