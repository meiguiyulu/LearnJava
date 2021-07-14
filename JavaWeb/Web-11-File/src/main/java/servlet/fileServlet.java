package main.java.servlet;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * @author LYJ
 * @create 2021-07-14 14:27
 */
public class fileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 判断上传的文件是普通表单还是带文件的表单
        if (!ServletFileUpload.isMultipartContent(req)){
            return; // 终止方法, 说明这是一个普通的表单, 直接返回
        }
        // 创建文件的保存路径, 建议在WEB-INF路径下, 因为用户无法直接访问该路径下的东西，安全
        String realPath = this.getServletContext().getRealPath("/WEB-INF/upload");
        File uploadFile = new File(realPath);
        if (!uploadFile.exists()){
            uploadFile.mkdir(); // 创建这个目录
        }
        // 缓存
        // 临时路径, 加入文件超出了预期的大小, 就把这个文件放到一个临时路径中，过几天自动删除，或者提醒用户转存为永久
        String tmpPath = this.getServletContext().getRealPath("/WEB-INF/tmp");
        File tmpFile = new File(tmpPath);
        if (!tmpFile.exists()){
            tmpFile.mkdir(); // 存放临时文件的目录
        }


    }
}
