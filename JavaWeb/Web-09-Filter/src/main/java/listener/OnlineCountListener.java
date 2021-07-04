package listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author LYJ
 * @create 2021-07-04 18:41
 */

// 统计网站在线人数---->统计session个数
public class OnlineCountListener implements HttpSessionListener {
    /**
     * 创建Session监听
     * 一旦创建Session就会触发一次
     * @param httpSessionEvent
     */
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        ServletContext context = httpSessionEvent.getSession().getServletContext();

        System.out.println(httpSessionEvent.getSession().getId());

        Integer onlineCount = (Integer) context.getAttribute("onlineCount");

        if (onlineCount == null){
            onlineCount = new Integer(0);
        } else {
            int count = onlineCount.intValue();
            onlineCount = new Integer(count+1);
        }
        context.setAttribute("onlineCount", onlineCount);
    }

    /**
     * 销毁Session监听
     * 一旦Session销毁就会触发一次
     * @param httpSessionEvent
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        ServletContext context = httpSessionEvent.getSession().getServletContext();
        Integer onlineCount = (Integer) context.getAttribute("onlineCount");

        if (onlineCount == null){
            onlineCount = 0;
        } else {
            int count = onlineCount.intValue();
            onlineCount = count - 1;
        }
        context.setAttribute("onlineCount", onlineCount);
    }
}
