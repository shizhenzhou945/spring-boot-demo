package com.github.wenslo.springbootdemo.controller;

import com.github.wenslo.springbootdemo.security.SecurityUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年12月12日 上午10:20
 * @description controller 基类
 */
public abstract class BaseController {
    @Autowired
    protected Gson gson;

    protected String getLoginUsername() {
        return SecurityUtil.getLoginUser().getUsername();
    }
}
