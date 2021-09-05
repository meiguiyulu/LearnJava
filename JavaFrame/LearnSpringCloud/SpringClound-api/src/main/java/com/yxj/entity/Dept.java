package com.yxj.entity;

import java.io.Serializable;

/**
 * 部门表(Dept)实体类
 *
 * @author makejava
 * @since 2021-08-09 21:56:37
 */

public class Dept implements Serializable {
    private static final long serialVersionUID = -41763328913430636L;

    private Long deptNo;

    private String dname;

    private String dbSource;


    public Long getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Long deptNo) {
        this.deptNo = deptNo;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDbSource() {
        return dbSource;
    }

    public void setDbSource(String dbSource) {
        this.dbSource = dbSource;
    }

}
