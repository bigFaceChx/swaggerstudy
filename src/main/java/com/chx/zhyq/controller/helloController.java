package com.chx.zhyq.controller;

import com.chx.zhyq.vo.user;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
    @ApiOperation("请求用户方法")
    @GetMapping("/user")
    public user user(@ApiParam("输入用户") user user){
        return user;
    }

}
