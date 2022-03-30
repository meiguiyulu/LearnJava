import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import entity.Card;
import entity.Employee;
import entity.Order;
import entity.User;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class TestPOI {

    public List<User> getUser() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(String.valueOf(i));
            user.setName("小杰" + i);
            user.setAge(10 + i);
            user.setBirthday(new Date());
            if (i%2==0) {
                user.setHobbies(Arrays.asList("篮球", "足球", "乒乓球"));
            } else {
                user.setHobbies(Arrays.asList("阅读", "音乐", "电影"));
            }
            Card card = new Card();
            card.setNumber("123456789123456789");
            card.setAddress("吉林省长春市朝阳区吉林大学前卫南区");
            user.setCard(card);

            List<Order> orders = new ArrayList<>();
            orders.add(new Order("12", "数据结构"));
            orders.add(new Order("13", "数据库"));
            orders.add(new Order("14", "操作系统"));

            user.setOrders(orders);
            user.setPhoto("D:/相册/给你fafa.png");

            users.add(user);
        }
        return users;
    }

    // 导出
    @Test
    public void testExport() throws IOException {
        List<User> users = getUser();
        // 导出Excel
        // ExcelExportUtil.exportExcel三个参数：
        // 参数1：ExportParams对象 参数2：导出的类型，即Excel对应的类 参数3：导出的数据
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("用户信息列表", "用户信息"), User.class, users);
        // 将Excel写出指定位置
        FileOutputStream outputStream = new FileOutputStream("D:/写代码/Java/LearnJava/LearnEasyPOI/src/test/java/excel.xlsx");
        workbook.write(outputStream);
        outputStream.close();
        workbook.close();
    }

    @Test
    public void testImport() throws Exception {
        ImportParams importParams = new ImportParams();
        importParams.setTitleRows(1); // 标题列占几行
        importParams.setHeadRows(2); //header占几行
        // 参数1：带入的excel文件流；参数2：导入类型；参数3：导入的配置对象
        List<Employee> objects = ExcelImportUtil.importExcel(new FileInputStream("D:/写代码/Java/LearnJava/LearnEasyPOI/src/test/java/test.xlsx"), Employee.class, importParams);
        objects.forEach(System.out::println);
    }

}
