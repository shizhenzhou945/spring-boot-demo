package com.github.wenslo.springbootdemo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年12月16日 上午11:11
 * @description
 */
@Configuration
public class FeignConfig {
    private static final Logger logger = LoggerFactory.getLogger(FeignConfig.class);

    public CustomAuthRequestInterceptor interceptor;

    @Scope("prototype")
    @Bean(initMethod = "init")
    public CustomAuthRequestInterceptor getBasicAuthRequestInterceptor() {
//        if (SecurityUtil.isAuthentication()) {
//            User user = SecurityUtil.getLoginUser();
//            return new CustomAuthRequestInterceptor(user.getUsername(), user.getPassword());
//        }
//        return interceptor;
        return new CustomAuthRequestInterceptor("user1", "1234");
    }

}
