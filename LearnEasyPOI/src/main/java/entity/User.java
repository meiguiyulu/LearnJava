package entity;

import cn.afterturn.easypoi.excel.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Data
@ExcelTarget("users")
public class User implements Serializable {

    @Excel(name = "编号", orderNum = "1", needMerge = true)
    private String id;
    @Excel(name = "姓名", orderNum = "2", needMerge = true)
    private String name;
    @Excel(name = "年龄", orderNum = "4", suffix = "$", replace = {"10岁_10", "12岁_12"}, needMerge = true)
    private Integer age;
    @Excel(name = "生日", width = 30.0, format = "yyyy-MM-dd HH:mm:ss", orderNum = "3", needMerge = true)
    private Date birthday;

    //    @Excel(name = "爱好", width = 30.0, orderNum = "5")
    @ExcelIgnore
    private List<String> hobbies;

    @Excel(name = "爱好", width = 30.0, orderNum = "5", needMerge = true)
    private String hobby;

    public String getHobby() {
        StringBuilder builder = new StringBuilder();
        hobbies.forEach(e -> {
            builder.append(e).append("、");
        });
        return builder.substring(0, builder.length() - 1).toString();
    }
    @ExcelEntity // 标志对象之间 一对一
    private Card card;

    @ExcelCollection(name = "订单列表", orderNum = "8") // 一对多
    private List<Order> orders;

    @Excel(name = "头像", type = 2, width = 20, imageType = 1)// 2表示图像
    private String photo;
}
