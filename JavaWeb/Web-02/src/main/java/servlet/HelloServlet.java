package servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author LYJ
 * @create 2021-07-01 14:41
 */
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        this.getInitParameter(); 初始化参数
//        this.getServletConfig()  Servlet配置

        ServletContext servletContext = this.getServletContext();
        String name = "云小杰"; // 数据
        servletContext.setAttribute("username", name); // 将一个数据存放在Servlet中，名字是username，值是name

        System.out.println("Hello");
    }
}
