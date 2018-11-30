package com.github.wenslo.springbootdemo.reposiroty;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.wenslo.springbootdemo.BaseTestCase;
import com.github.wenslo.springbootdemo.model.User;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年11月24日 下午6:11
 * @description
 */
@DatabaseSetup(value = "/dataset.xml")
public class UserRepositoryTest extends BaseTestCase {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Gson gson;

    @Test
    public void testFindAll() {
        List<User> list = userRepository.findAll();
        logger.info("list size is {}", list.size());
        logger.info("list data is {}", gson.toJson(list));
        Assert.assertTrue(!list.isEmpty());
    }

    @Test
    public void testFindByUsername() {
        String username = "user1";
        User user = userRepository.findByUsername(username);
        Assert.assertNotNull(user);
        logger.info("username is {} , findByUsername result is {}", gson.toJson(user));
    }
}