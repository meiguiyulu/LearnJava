package entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
@ExcelTarget("Employee")
public class Employee implements Serializable {

    @Excel(name = "编号")
    private String id;
    @Excel(name = "姓名")
    private String name;
    @Excel(name = "生日", format = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;
    @Excel(name = "年龄")
    private Integer age;
}
