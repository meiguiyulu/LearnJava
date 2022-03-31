package com.lyj.easypoi_springboot.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.util.Date;

@Data
@ExcelTarget("user")
public class User {

    @Excel(name = "编号")
    private String id;
    @Excel(name = "姓名")
    private String name;
    @Excel(name = "生日", format = "yyyy年MM月dd日")
    private Date bir;
    @Excel(name = "身份证号")
    private String no;
    @Excel(name = "籍贯")
    private String address;
}
