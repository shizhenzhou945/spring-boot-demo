package com.github.wenslo.springbootdemo.controller;

import com.github.wenslo.springbootdemo.cache.EnumCollector;
import com.github.wenslo.springbootdemo.cache.PermissionCollector;
import com.github.wenslo.springbootdemo.domain.Response;
import com.github.wenslo.springbootdemo.model.system.Permission;
import com.github.wenslo.springbootdemo.security.SecurityUtil;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

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
        boolean isAdministrator = SecurityUtil.getLoginUser().getPermission().stream().anyMatch(s -> Objects.equals(s.getValue(), "administrator"));
        if (isAdministrator) {
            map.put("permission", PermissionCollector.permission);
        } else {
            map.put("permission", SecurityUtil.getLoginUser().getPermission().stream().collect(Collectors.groupingBy(Permission::getGroup)));
        }
        map.put("enums", enumCollector.enums);
        return Response.success(map);
    }

}
