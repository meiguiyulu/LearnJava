package com.example.springcloudproviderdept8001.dao;

import com.yxj.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author LYJ
 * @create 2021-08-09 22:08
 */


@Mapper
@Repository
public interface DeptDao {

    boolean addDept(Dept dept);

    Dept queryId(Long id);

    List<Dept> queryAll();
}
