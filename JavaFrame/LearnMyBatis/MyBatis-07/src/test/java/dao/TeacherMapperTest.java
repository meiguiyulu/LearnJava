package dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.Teacher;
import utils.MyBatisUtils;

import java.util.List;

/**
 * @author LYJ
 * @create 2021-06-23 21:30
 */
public class TeacherMapperTest {
    public static void main(String[] args) {

    }
    @Test
    public void getTeachers(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teachers = mapper.getTeachers();
        for (Teacher teacher:teachers){
            System.out.println(teacher);
        }

        sqlSession.close();
    }
}
