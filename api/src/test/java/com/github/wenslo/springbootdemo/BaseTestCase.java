package com.github.wenslo.springbootdemo;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;


/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年11月25日 下午12:45
 * @description facade层的测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootDemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public abstract class BaseTestCase {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private WebApplicationContext context;

    protected MockMvc mvc;

    @Before
    public void setup() {
        this.mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

//    protected Response get(String url) throws Exception {
//        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(url).header("Origin", "*").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
//        return null;
//    }

}
