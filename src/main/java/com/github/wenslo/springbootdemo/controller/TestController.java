package com.github.wenslo.springbootdemo.controller;

import com.github.wenslo.springbootdemo.domain.Response;
import com.github.wenslo.springbootdemo.security.SecurityUtil;
import com.github.wenslo.springbootdemo.service.UserService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private Gson gson;
    @Autowired
    private UserService userService;


    @RequestMapping("/getAll")
    public Response getAll() {
        Object loginUser = SecurityUtil.getLoginUser();
        logger.info("loginUser is {}", gson.toJson(loginUser));
        return Response.success(userService.getAll());
    }
}
