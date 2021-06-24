package dao;

import pojo.Blog;

import java.util.List;
import java.util.Map;

/**
 * @author LYJ
 * @create 2021-06-24 10:12
 */
public interface BlogMapper {

    /**
     * 插入数据
     * @param blog
     * @return
     */
    void insertBlog(Blog blog);

    /**
     * 查询博客
     * @param map
     * @return
     */
    List<Blog> queryBlog(Map map);

    List<Blog> queryBlogChoose(Map map);

}
