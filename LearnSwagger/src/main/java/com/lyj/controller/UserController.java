package com.lyj.controller;

import com.lyj.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Api(tags = "用户服务相关接口描述")
public class UserController {

    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有用户接口",
            notes = "<span style='color:red;'>描述:</span>&nbsp;&nbsp;用来查询所有用户信息的接口")
    public Map<String, Object> findAll() {
        Map<String, Object> map = new HashMap<>();
        map.put("success", "查询成功");
        map.put("status", true);
        return map;
    }

/*    @PostMapping("/save")
    @ApiOperation(value = "保存用户信息接口",
            notes = "<span style='color:red;'>描述:</span>&nbsp;&nbsp;用来保存用户信息的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户 id", dataType = "String", defaultValue = "21"),
            @ApiImplicitParam(name = "name", value = "用户姓名", dataType = "String", defaultValue = "白衣")
    })
    public Map<String, Object> save(String id, String name) {
        System.out.println("id = " + id);
        System.out.println("name = " + name);
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("name", name);
        return map;
    }*/
/*    @PostMapping("/save/{id}/{name}")
    @ApiOperation(value = "保存用户信息接口",
            notes = "<span style='color:red;'>描述:</span>&nbsp;&nbsp;用来保存用户信息的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户 id", dataType = "String", defaultValue = "21", paramType = "path"),
            @ApiImplicitParam(name = "name", value = "用户姓名", dataType = "String", defaultValue = "白衣", paramType = "path")
    })
    public Map<String, Object> save(@PathVariable("id") String id, @PathVariable("name") String name) {
        System.out.println("id = " + id);
        System.out.println("name = " + name);
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("name", name);
        return map;
    }*/

    @PostMapping("/save")
    @ApiOperation(value = "保存用户信息接口",
            notes = "<span style='color:red;'>描述:</span>&nbsp;&nbsp;用来保存用户信息的接口")
    @ApiResponses({
            @ApiResponse(code = 404, message = "请求路径不对"),
            @ApiResponse(code = 400, message = "程序不对")
    })
    /* 参数为对象的时候不需要使用 @ApiImplicitParams注解 */
    public Map<String, Object> save(@RequestBody User user) {
        System.out.println("id = " + user.getId());
        System.out.println("name = " + user.getName());
        Map<String, Object> map = new HashMap<>();
        map.put("id", user.getId());
        map.put("name", user.getName());
        return map;
    }
}

