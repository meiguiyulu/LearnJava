package com.lyj.easypoi_springboot.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.lyj.easypoi_springboot.entity.User;
import com.lyj.easypoi_springboot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // 导出Excel文件
    @RequestMapping("/export")
    public void exportExcel(HttpServletResponse response) throws Exception {
        // 查询所有数据
        List<User> users = userService.findAll();
        //导出excel
        response.setHeader("content-disposition", "attachment;fileName=" + URLEncoder.encode("用户列表.xls", "UTF-8"));
        ServletOutputStream outputStream = response.getOutputStream();
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("学生列表信息", "学生信息"), User.class, users);
        workbook.write(outputStream);
        outputStream.close();
        workbook.close();
    }

    // 导入Excel文件
    @RequestMapping("/import")
    public String importExcel(MultipartFile excelFile) throws Exception {
        log.info("文件名称: [{}]", excelFile.getOriginalFilename());

        // excel导入
        ImportParams params = new ImportParams();
        params.setTitleRows(1);
        params.setHeadRows(1);
        List<User> objects = ExcelImportUtil.importExcel(excelFile.getInputStream(), User.class, params);
        objects.forEach(System.out::println);
        userService.saveAll(objects);

        return "redirect:/user/findAll";
    }

    // 查询所有
    @RequestMapping("/findAll")
    public String findAll(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "index";
    }


}
