package servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author LYJ
 * @create 2021-07-02 16:49
 */
public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 如何让浏览器3s刷新一次
        resp.setHeader("refresh", "3");

        // 在内存中创建图片
        BufferedImage bufferedImage = new BufferedImage(160, 90, BufferedImage.TYPE_INT_RGB);
        // 得到图片
        Graphics2D graph = (Graphics2D) bufferedImage.getGraphics();
        // 设置背景颜色
        graph.setColor(Color.WHITE);
        graph.fillRect(0, 0, 160, 90);

        // 给图片写数据
        graph.setColor(Color.PINK);
        graph.setFont(new Font(null, Font.ITALIC, 18));
        graph.drawString(makeNum(), 0, 20);

        // 告诉浏览器，该请求用图片的方式打开
        resp.setContentType("image/jpeg");
        // 不让浏览器缓存
        resp.setDateHeader("expires", -1);
        resp.setHeader("Cache-Control", "no-cache");
        resp.setHeader("Pragma", "no-cache");

        // 图片写给浏览器
        ImageIO.write(bufferedImage, "jpg",resp.getOutputStream());

    }

    /**
     * 生成随机数
     */
    private String makeNum(){
        // 随机产生一个7位数的字符串
        StringBuilder builder = new StringBuilder();
        for (int i=0;i<7;++i){
            builder.append(Math.random() * 10);
        }
        return  builder.toString();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
