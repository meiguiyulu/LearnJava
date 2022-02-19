package dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.Student;
import utils.MyBatisUtils;

import java.util.List;

/**
 * @author LYJ
 * @create 2021-06-23 19:59
 */
public class StudentMapperTest {
    public static void main(String[] args) {

    }


    @Test
    public void getStudent() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.getStudent2();
        for (Student student : students) {
            System.out.println(student);
        }

        sqlSession.close();
    }
}
