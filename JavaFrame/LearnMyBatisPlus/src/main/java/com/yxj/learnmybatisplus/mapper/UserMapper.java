package com.yxj.learnmybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yxj.learnmybatisplus.pojo.User;
import org.springframework.stereotype.Repository;

// 在对应的Mapper上面继承基本的类 BaseMapper
@Repository
public interface UserMapper extends BaseMapper<User> {
    /**
     * 所有的CRUD操作已经完成
     * */
}
