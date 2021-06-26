package dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.Blog;
import utils.IDutils;
import utils.MyBatisUtils;

import java.util.*;

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

    @Test
    public void updateBlogSet(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Map map = new HashMap();
        map.put("id", "c6cb9dbdac7345da8743c2d421e398ae");
        map.put("title", "加油");
//        map.put("author", "云小杰");
        int i = mapper.updateBlog(map);
        if (i>0){
            System.out.println("更新成功!");
        }

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void queryBlogForeach(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map map = new HashMap();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        map.put("ids", list);

        List<Blog> blogs = mapper.queryBlogForeach(map);
        for (Blog blog:blogs){
            System.out.println(blog);
        }
        sqlSession.close();
    }
}
