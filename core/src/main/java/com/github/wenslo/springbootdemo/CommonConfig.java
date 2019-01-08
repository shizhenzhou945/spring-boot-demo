package com.github.wenslo.springbootdemo;

import com.google.common.eventbus.AsyncEventBus;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2019-01-07 20:32
 * @description
 */
@Configuration
public class CommonConfig {

    @Bean
    public Gson gson() {
        return new GsonBuilder().create();
    }

    @Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        return new ThreadPoolTaskExecutor();
    }

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Bean
    public AsyncEventBus eventBus() {
        return new AsyncEventBus(threadPoolTaskExecutor);
    }
}
