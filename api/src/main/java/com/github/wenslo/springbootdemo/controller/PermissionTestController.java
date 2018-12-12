package com.github.wenslo.springbootdemo.controller;

import com.github.wenslo.springbootdemo.domain.Response;
import com.github.wenslo.springbootdemo.permission.SystemPermission;
import com.github.wenslo.springbootdemo.service.system.UserService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
public class PermissionTestController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private Gson gson;
    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/role")
    public Response role() {
        return Response.success(userService.getAll());
    }

    @PreAuthorize("hasAuthority('" + SystemPermission.USER_ADD + "')")
    @RequestMapping("/permission")
    public Response permission() {
        return Response.success(userService.getAll());
    }


    @RequestMapping("/noPermission")
    public Response noPermission() {
        return Response.success(userService.getAll());
    }
}
