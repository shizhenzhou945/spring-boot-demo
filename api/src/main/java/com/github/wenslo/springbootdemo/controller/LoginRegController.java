package com.github.wenslo.springbootdemo.controller;

import com.github.wenslo.springbootdemo.cache.EnumCollector;
import com.github.wenslo.springbootdemo.cache.PermissionCollector;
import com.github.wenslo.springbootdemo.domain.Response;
import com.github.wenslo.springbootdemo.security.SecurityUtil;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年11月29日 下午5:52
 * @description
 */
@RestController
public class LoginRegController {
    @Autowired
    private EnumCollector enumCollector;

    @RequestMapping("/login_page")
    public Response loginPage() {
        return Response.UNAUTHORIZED;
    }

    @RequestMapping("/me")
    public Response me() {
        Map<String, Object> map = Maps.newHashMap();
        map.put("user", SecurityUtil.getLoginUser());
        if (SecurityUtil.getLoginUser().getPermission().contains("administrator")) {
            map.put("permission", PermissionCollector.permission);
        }
        map.put("enums", enumCollector.enums);
        return Response.success(map);
    }

}
