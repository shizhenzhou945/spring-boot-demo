package com.github.wenslo.springbootdemo.controller;

import com.github.wenslo.springbootdemo.BaseTestCase;
import com.google.gson.Gson;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public class PermissionTestControllerTest extends BaseTestCase {

    @Autowired
    private Gson gson;

    @Test
    @WithMockUser
    public void testRole() throws Exception {
        MockHttpServletResponse user2 = mvc.perform(get("/test/role").with(user("user2").password("1234")).content("application/json")).andReturn().getResponse();
        logger.info("-------------------------testRole test result is {}",gson.toJson(user2));
    }
    @Test
    @WithMockUser
    public void testPermission() throws Exception {
        MockHttpServletResponse user2 = mvc.perform(get("/test/permission").with(user("user2").password("1234")).content("application/json")).andReturn().getResponse();
        logger.info("-------------------------testPermission test result is {}",gson.toJson(user2));
    }
    @Test
    @WithMockUser
    public void testNoPermission() throws Exception {
        MockHttpServletResponse user2 = mvc.perform(get("/test/noPermission").with(user("user2").password("1234")).content("application/json")).andReturn().getResponse();
        logger.info("-------------------------testNoPermission test result is {}",gson.toJson(user2));
    }
}