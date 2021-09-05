package com.example.springcloudproviderdept8001.service;

import com.example.springcloudproviderdept8001.dao.DeptDao;
import com.yxj.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LYJ
 * @create 2021-08-09 22:17
 */

@Service
public class DeptServiceImpl implements DeptService{

    @Autowired
    private DeptDao deptDao;

    @Override
    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept queryId(Long id) {
        return deptDao.queryId(id);
    }

    @Override
    public List<Dept> queryAll() {
        return deptDao.queryAll();
    }
}
