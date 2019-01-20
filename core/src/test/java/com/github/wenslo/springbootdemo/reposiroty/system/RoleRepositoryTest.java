package com.github.wenslo.springbootdemo.reposiroty.system;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.wenslo.springbootdemo.DBTestCase;
import com.github.wenslo.springbootdemo.model.system.QRole;
import com.github.wenslo.springbootdemo.model.system.Role;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年12月12日 上午11:32
 * @description
 */
@DatabaseSetup(value = "/dataset.xml")
public class RoleRepositoryTest extends DBTestCase {

    @Autowired
    private RoleRepository roleRepository;


    @Test
    public void testFindAll() {
        List<Role> list = roleRepository.findAll();
        logger.debug("list size is {}", list.size());
        logger.debug("list data is {}", list);
        Assert.assertTrue(!list.isEmpty());
    }

    @Test
    public void testQuerydsl() {
        String roleName = "user";
        QRole role = QRole.role;
        BooleanExpression booleanExpression = role.name.startsWith(roleName);
        Optional one = roleRepository.findOne(booleanExpression);
        Assert.assertTrue(one.isPresent());
        logger.info("one is {}", one.get());
    }
}
