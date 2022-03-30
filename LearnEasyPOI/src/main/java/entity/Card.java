package entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@ExcelTarget("cards")
public class Card implements Serializable {
    @Excel(name = "身份证号码", width = 20.0, orderNum = "6")
    private String number;
    @Excel(name = "籍贯", width = 40.0, orderNum = "7")
    private String address;
}
