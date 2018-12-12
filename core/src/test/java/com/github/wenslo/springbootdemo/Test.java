package com.github.wenslo.springbootdemo;

import com.github.wenslo.springbootdemo.model.system.Permission;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年12月11日 上午10:57
 * @description
 */
public class Test {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().create();
        Permission permission = new Permission("USER_ADD", "用户添加", true, "用户相关权限");
        Permission permission1 = new Permission("USER_VIEW", "用户查看", true, "用户相关权限");
        Permission permission2 = new Permission("USER_DELETE", "用户删除", true, "用户相关权限");
        Permission permission3 = new Permission("USER_UPDATE", "用户修改", true, "用户相关权限");
        List<Permission> list = Lists.newArrayList(permission, permission1, permission2, permission3);
        System.out.println(gson.toJson(list));
    }
}
