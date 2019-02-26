package com.github.wenslo.springbootdemo.service.administration;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.wenslo.springbootdemo.DBTestCase;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2019-01-08 17:12
 * @description
 */
@DatabaseSetup(value = "/dataset.xml")
@Ignore
public class DepartmentServiceTest extends DBTestCase {
    @Autowired
    private DepartmentService departmentService;


    @Test
    public void testFindChildDepartmentIds() {
        Long id = -1L;
        List<Long> ids = departmentService.findChildDepartmentIds(id);
        logger.debug("id is {},result is {}", id, ids);
        Assert.assertFalse(ids.isEmpty());
    }
}
