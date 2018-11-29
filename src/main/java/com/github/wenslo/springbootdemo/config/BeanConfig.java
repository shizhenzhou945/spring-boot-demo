package com.github.wenslo.springbootdemo.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年11月29日 下午2:31
 * @description
 */
@Configuration
public class BeanConfig {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public Gson gson() {
        return new GsonBuilder().create();
    }


}
