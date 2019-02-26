package com.github.wenslo.springbootdemo.system;

import com.github.wenslo.springbootdemo.BaseTestCase;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2019-02-25 15:09
 * @description
 */
@AutoConfigureRestDocs
public class UserControllerTest extends BaseTestCase {
    @WithMockUser("user1")
    @Test
    public void testGetAll() throws Exception {
        MockMvc mvc = super.mvc;
        mvc.perform(MockMvcRequestBuilders
                .get("/user/queryAll")
                .header("Origin", "*")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(document("index"));
//        logger.debug("mvc result is {}", mvcResult.getResponse().getContentAsString());
    }
}
