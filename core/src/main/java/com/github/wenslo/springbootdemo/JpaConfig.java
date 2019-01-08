package com.github.wenslo.springbootdemo;

import com.google.common.eventbus.AsyncEventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年12月06日 上午10:54
 * @description
 */
@EntityScan({"com.github.wenslo.springbootdemo.model"})
@Configuration
@EnableAutoConfiguration
@EnableJpaAuditing
@EnableAsync
@EnableJpaRepositories(basePackages = "com.github.wenslo.springbootdemo.reposiroty")
@ComponentScan("com.github.wenslo.springbootdemo")
@Import({CommonConfig.class})
public class JpaConfig {
    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Bean
    public AsyncEventBus eventBus() {
        return new AsyncEventBus(threadPoolTaskExecutor);
    }

}
