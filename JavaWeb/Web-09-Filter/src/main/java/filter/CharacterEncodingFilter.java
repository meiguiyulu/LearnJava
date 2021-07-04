package filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author LYJ
 * @create 2021-07-04 15:25
 */
public class CharacterEncodingFilter implements Filter {

    /**
     * web服务器启动，过滤器初始化：随时等待过滤对象出现
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化完成!");
    }

    /**
     * 1、过滤中的所有代码，在过滤特定请求时都会执行
     * 2、必须要让过滤器继续通行：filterChain.doFilter(request, response);
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");

        System.out.println("执行前");
        filterChain.doFilter(request, response); // 让我们的程序继续走，如果不写，程序到这里就会被拦截而停止了
        System.out.println("执行后");
    }

    /**
     * web服务器关闭的时候，过滤器才会销毁
     */
    @Override
    public void destroy() {
        System.out.println("销毁!");
    }
}
