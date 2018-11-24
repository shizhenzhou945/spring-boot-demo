package com.github.wenslo.springbootdemo.repository;

import com.github.wenslo.springbootdemo.SpringBootDemoApplicationTests;
import com.github.wenslo.springbootdemo.model.User;
import com.github.wenslo.springbootdemo.reposiroty.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年11月24日 下午6:11
 * @description
 */
public class UserRepositoryTest extends SpringBootDemoApplicationTests {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindAll() {
        List<User> list = userRepository.findAll();
        logger.debug("list is {}",list);
        Assert.assertTrue(!list.isEmpty());
    }
}
