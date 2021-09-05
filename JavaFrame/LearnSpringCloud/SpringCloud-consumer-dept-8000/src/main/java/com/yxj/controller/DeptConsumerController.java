package com.yxj.controller;


import com.yxj.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class DeptConsumerController {
    /**
     * 消费者不应该有service层
     *
     *(String url, Class<T> responseType, Map<String, ?> uriVariables)
     */
    @Autowired
    private RestTemplate restTemplate; // 提供多种便捷访问远程HTTP的方法 简单的Restful服务模板

    private static final String REST_URL_PREFIX = "http://localhost:8001";


    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
    }

    @RequestMapping("/consumer/dept/get/id")
    public Dept dept(@PathVariable("id") Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/query/" + id, Dept.class);
    }


    @RequestMapping("/consumer/dept/list")
    public List<Dept> list() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }

}
