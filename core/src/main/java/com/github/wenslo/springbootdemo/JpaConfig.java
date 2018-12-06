package com.github.wenslo.springbootdemo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年12月06日 上午10:54
 * @description
 */
@EntityScan({"com.github.wenslo.springbootdemo.model"})
@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages="com.github.wenslo.springbootdemo.reposiroty")
@ComponentScan("com.github.wenslo")
public class JpaConfig {
    @Bean
    public Gson gson() {
        return new GsonBuilder().create();
    }
}
