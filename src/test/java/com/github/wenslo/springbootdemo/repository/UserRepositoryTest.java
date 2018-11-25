package com.github.wenslo.springbootdemo.repository;

import com.github.wenslo.springbootdemo.BaseTestCase;
import com.github.wenslo.springbootdemo.model.User;
import com.github.wenslo.springbootdemo.reposiroty.UserRepository;
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

public class UserRepositoryTest extends BaseTestCase {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindAll() {
        List<User> list = userRepository.findAll();
        logger.info("list size is {}", list.size());
        Assert.assertTrue(!list.isEmpty());
    }

}
