package com.github.wenslo.springbootdemo.controller;

import com.github.wenslo.springbootdemo.domain.Response;
import com.github.wenslo.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年11月24日 下午3:58
 * @description
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private UserService userService;

    @RequestMapping("/getAll")
    public Response getAll() {
        Response response = new Response();
        response.setOb(userService.getAll());
        return response;
    }
}
