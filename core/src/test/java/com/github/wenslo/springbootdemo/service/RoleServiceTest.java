package com.github.wenslo.springbootdemo.service;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.wenslo.springbootdemo.BaseTestCase;
import com.github.wenslo.springbootdemo.condition.system.RoleCondition;
import com.github.wenslo.springbootdemo.model.system.Role;
import com.github.wenslo.springbootdemo.service.system.RoleService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2019-01-01 16:07
 * @description
 */
@DatabaseSetup(value = "/dataset.xml")
public class RoleServiceTest extends BaseTestCase {
    @Autowired
    private RoleService roleService;

    @Test
    public void testGetByCondition() {
        String roleName = "user";
        Long roleId = -1L;
        RoleCondition condition = new RoleCondition();
//        condition.setRoleName(roleName);
        condition.setId(roleId);
        List<Role> list = roleService.getByCondition(condition);
        Assert.assertTrue(!list.isEmpty());
        logger.debug("testGetByCondition parameter is {},result is {}", gson.toJson(condition), gson.toJson(list));
    }
}
