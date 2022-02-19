package dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.Teacher;
import utils.MyBatisUtils;

/**
 * @author LYJ
 * @create 2021-06-23 19:41
 */
public class TeacherMapperTest {

    @Test
    public void getTeacher() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);

        sqlSession.close();
    }

}
