package com.github.wenslo.springbootdemo;

import com.google.gson.Gson;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2019-01-07 17:45
 * @description
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(classes = {MongoConfig.class, CommonConfig.class})
public abstract class MongoTestCase {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    protected Gson gson;
}
