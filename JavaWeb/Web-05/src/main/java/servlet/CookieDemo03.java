package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author LYJ
 * @create 2021-07-03 13:27
 */
// 传递中文数据
public class CookieDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");

        PrintWriter out = resp.getWriter();

        Cookie[] cookies = req.getCookies();
        if (cookies != null){
            out.write("名字");
            for (int i=0;i<cookies.length;++i){
                Cookie cookie = cookies[i];
                if ("name".equals(cookie.getName())){
                    System.out.println(cookie.getValue());
                    out.write(cookie.getValue());
                }
            }
        } else {
            System.out.println("第一次");
            out.write("第一次");
        }

        Cookie cookie = new Cookie("name", "云小杰");

        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
