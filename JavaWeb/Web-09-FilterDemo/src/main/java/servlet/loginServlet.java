package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author LYJ
 * @create 2021-07-04 19:52
 */
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 获取前端请求的参数
        String username = req.getParameter("username");

        System.out.println("=========================");

        if ("admin".equals(username)){ // 登陆成功
            req.getSession().setAttribute("USER_SESSION", req.getSession().getId());
            resp.sendRedirect(req.getContextPath() + "/sys/home.jsp");
        } else { // 登陆失败
            resp.sendRedirect(req.getContextPath() + "/error.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
