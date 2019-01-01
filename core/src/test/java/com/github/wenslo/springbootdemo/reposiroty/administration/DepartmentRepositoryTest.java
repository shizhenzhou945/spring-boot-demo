package com.github.wenslo.springbootdemo.reposiroty.administration;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.wenslo.springbootdemo.BaseTestCase;
import com.github.wenslo.springbootdemo.model.administration.Department;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2019-01-01 14:05
 * @description 部门
 */
@DatabaseSetup(value = "/dataset.xml")
public class DepartmentRepositoryTest extends BaseTestCase {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    public void testFindByOrganizationIdEquals() {
        Long organizationId = -1L;
        List<Department> data = departmentRepository.findByOrganizationIdEquals(organizationId).get();
        Assert.assertTrue(!data.isEmpty());
        logger.debug("findByOrganizationIdEquals parameter is {},result is {}", organizationId, data);
    }

    @Test
    public void testFindByOrganizationHeadquartersIdEquals() {
        Long organizationId = null;
        List<Department> data = departmentRepository.findByOrganizationHeadquartersIdEquals(organizationId).get();
        Assert.assertTrue(!data.isEmpty());
        logger.debug("testFindByOrganizationHeadquartersIdEquals parameter is {},result is {}", organizationId, data);
    }

}