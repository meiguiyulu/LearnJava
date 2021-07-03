package servlet;

import pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author LYJ
 * @create 2021-07-03 14:54
 */
public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解决乱码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        // 得到Session
        HttpSession session = req.getSession();

        // 给Session中存东西
        session.setAttribute("name", new Person(18, "云小杰"));

        // 获取Session的ID
        String id = session.getId();

        // 判断Session是不是新创建的
        if (session.isNew()){
            resp.getWriter().print("Session创建成功, ID=" + id);
        } else {
            resp.getWriter().print("Session已经存在, ID=" + id);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
