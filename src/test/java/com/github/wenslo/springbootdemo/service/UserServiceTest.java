package com.github.wenslo.springbootdemo.service;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.wenslo.springbootdemo.BaseTestCase;
import com.github.wenslo.springbootdemo.condition.UserCondition;
import com.github.wenslo.springbootdemo.domain.Pageable;
import com.github.wenslo.springbootdemo.model.User;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年12月03日 下午8:30
 * @description
 */
@DatabaseSetup(value = "/dataset.xml")
public class UserServiceTest extends BaseTestCase {

    @Autowired
    private UserService userService;
    @Autowired
    private Gson gson;

    @Test
    public void testFindAll() {
        UserCondition condition = new UserCondition();
        condition.setUsername("user2");
        Pageable pageable = new Pageable();
        Page<User> page = userService.getByCondition(condition, pageable);
        logger.info("page data is {}", gson.toJson(page));
        Assert.assertTrue(!page.isEmpty());
    }

}
