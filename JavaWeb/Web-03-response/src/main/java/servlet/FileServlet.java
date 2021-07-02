package servlet;


import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author LYJ
 * @create 2021-07-02 16:04
 */
public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("GBK");

        //获取下载文件的路径
        String path = "D:\\写代码\\Java\\LearnJava\\JavaWeb\\out\\artifacts\\Web_03_war\\WEB-INF\\classes\\2019.jpg";
//        String path = this.getServletContext().getRealPath(filepath);
        System.out.println("下载文件的路径：" + path);
        //下载的文件名是什么
        String filename = path.substring(path.lastIndexOf("\\") + 1);
        //让浏览器支持(Content-Disposition)下载我们需要的东西，中文文件名使用URLEncoder.encode(filename, "UTF-8")编码，否则可能乱码
        resp.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
        //获取下载文件的输入流
        FileInputStream inputStream = new FileInputStream(path);
        //创建缓冲区
        int len = 0;
        byte[] buffer = new byte[1024];
        //获取OutputStream对象
        ServletOutputStream outputStream = resp.getOutputStream();
        //将FileOutputStream流写入到buffer缓冲区，使用OutputStream将缓冲区中的数据输出到客户端
        while ((len=inputStream.read(buffer))>0){
            outputStream.write(buffer, 0, len);
        }

        inputStream.close();
        outputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
