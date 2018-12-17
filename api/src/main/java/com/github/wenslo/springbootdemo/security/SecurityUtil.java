package com.github.wenslo.springbootdemo.security;

import com.github.wenslo.springbootdemo.model.system.User;
import com.github.wenslo.springbootdemo.security.token.CustomAuthenticationToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Objects;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年11月30日 下午4:08
 * @description 登录工具类
 */
public class SecurityUtil {
    private static final Logger logger = LoggerFactory.getLogger(SecurityUtil.class);

    /**
     * 获取登录用户
     * @return 用户
     */
    public static User getLoginUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getDetails();
    }

    /**
     * 获取登录token
     * @return 登录token信息
     */
    public static CustomAuthenticationToken getLoginToken() {
        return (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 判断是否登录
     * @return yes or no
     */
    public static boolean isAuthentication() {
        return Objects.nonNull(SecurityContextHolder.getContext().getAuthentication());
    }
}
