package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @author LYJ
 * @create 2021-07-03 10:28
 */
public class CookieDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        PrintWriter out = resp.getWriter();
        // 从客户端取cookie
        Cookie[] cookies = req.getCookies();// 返回一个数组，说明cookie可能存在多个

        // 判断cookie是否存在
        if (cookies!=null){
            out.write("上一次登陆时间:");
            for (int i=0;i<cookies.length;++i){
                if ("lastLoginTime".equals(cookies[i].getName())){
                    // 获取Cookie的值
                    long lastLoginTime = Long.parseLong(cookies[i].getValue());
                    Date date = new Date(lastLoginTime);
                    out.write(date.toLocaleString());
                }
            }
        } else {
            out.write("这是第一次登录");
        }
        Cookie loginTime = new Cookie("lastLoginTime", System.currentTimeMillis() + "");
        // cookie有效期为一天
        loginTime.setMaxAge(24*60*60);
        resp.addCookie(loginTime);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
