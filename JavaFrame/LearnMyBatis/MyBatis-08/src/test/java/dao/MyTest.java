package dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.Blog;
import utils.IDutils;
import utils.MyBatisUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LYJ
 * @create 2021-06-24 10:26
 */
public class MyTest {

    @Test
    public void insertBlog(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDutils.getId());
        blog.setTitle("于撷思");
        blog.setAuthor("云小杰");
        blog.setCreateTime(new Date());
        blog.setViews(500);
        mapper.insertBlog(blog);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void queryBlog(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Map map = new HashMap();

        map.put("title", "Java");
        List<Blog> blogs = mapper.queryBlog(map);
        for (Blog blog: blogs){
            System.out.println(blog);
        }

        sqlSession.close();
    }

    @Test
    public void queryBlogChoose(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map map = new HashMap();
        map.put("author", "云小杰");
        map.put("title", "java");
        List<Blog> blogs = mapper.queryBlogChoose(map);
        for (Blog blog : blogs){
            System.out.println(blog);
        }

        sqlSession.close();
    }


}
