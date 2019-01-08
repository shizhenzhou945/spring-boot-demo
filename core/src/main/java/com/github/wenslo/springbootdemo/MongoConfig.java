package com.github.wenslo.springbootdemo;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoTypeMapper;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2019-01-07 17:23
 * @description
 */
@EnableMongoRepositories({"com.github.wenslo.springbootdemo.reposiroty"})
@Configuration
public class MongoConfig extends AbstractMongoConfiguration {
    @Override
    protected String getDatabaseName() {
        return "database";
    }

    @Override
    public MongoClient mongoClient() {
        return new MongoClient("192.168.1.221");
    }

    @Bean
    @Override
    public MappingMongoConverter mappingMongoConverter() throws Exception {
        MappingMongoConverter mmc = super.mappingMongoConverter();
        mmc.setTypeMapper(customTypeMapper());
        return mmc;
    }

    @Bean
    public MongoTypeMapper customTypeMapper() {
        return new CustomMongoTypeMapper();
    }

    private class CustomMongoTypeMapper extends DefaultMongoTypeMapper {
        //implement custom type mapping here
    }
}
