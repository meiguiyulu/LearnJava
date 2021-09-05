package com.example.springcloudproviderdept8001.service;

import com.yxj.entity.Dept;

import java.util.List;

/**
 * @author LYJ
 * @create 2021-08-09 22:16
 */


public interface DeptService {
    boolean addDept(Dept dept);

    Dept queryId(Long id);

    List<Dept> queryAll();
}
