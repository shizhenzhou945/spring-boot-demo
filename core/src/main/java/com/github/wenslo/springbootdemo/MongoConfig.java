package com.github.wenslo.springbootdemo;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Objects;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2019-01-07 17:23
 * @description
 */
@EnableMongoRepositories({"com.github.wenslo.springbootdemo.reposiroty"})
@Configuration
public class MongoConfig {
    private static final String MONGO_DATABASE_KEY = "spring.data.mongodb.database";
    private static final String MONGO_HOST_KEY = "spring.data.mongodb.host";
    private static final String MONGO_PORT_KEY = "spring.data.mongodb.port";
    private static final String DEFAULT_HOST = "127.0.0.1";
    private static final Integer DEFAULT_PORT = 27017;
    @Autowired
    private Environment environment;

    @Bean
    public MongoTemplate mongoTemplate() {
        String host = environment.getProperty(MONGO_HOST_KEY);
        host = Objects.isNull(host) ? DEFAULT_HOST : host;
        String portStr = environment.getProperty(MONGO_PORT_KEY);
        int port = Objects.isNull(portStr) ? DEFAULT_PORT : Integer.parseInt(portStr);
        MongoClient mongoClient = new MongoClient(host, port);
        return new MongoTemplate(mongoClient, Objects.requireNonNull(environment.getProperty(MONGO_DATABASE_KEY)));
    }
}
