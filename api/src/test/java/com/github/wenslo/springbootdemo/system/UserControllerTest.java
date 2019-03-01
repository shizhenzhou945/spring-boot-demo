package com.github.wenslo.springbootdemo.system;

import com.github.wenslo.springbootdemo.BaseTestCase;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2019-02-25 15:09
 * @description
 */
public class UserControllerTest extends BaseTestCase {
    @WithMockUser("user1")
    @Test
    public void testGetAll() throws Exception {
        MockMvc mvc = super.mvc;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders
                .get("/user/queryAll")
                .header("Origin", "*")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        logger.debug("mvc result is {}", mvcResult.getResponse().getContentAsString());
    }
}
