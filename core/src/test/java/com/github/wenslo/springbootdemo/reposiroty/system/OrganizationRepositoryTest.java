package com.github.wenslo.springbootdemo.reposiroty.system;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.wenslo.springbootdemo.BaseTestCase;
import com.github.wenslo.springbootdemo.model.system.Organization;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018-12-31 21:54
 * @description
 */
@DatabaseSetup(value = "/dataset.xml")
public class OrganizationRepositoryTest extends BaseTestCase {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Test
    public void testFindByDistrictCode() {
        String districtCode = "11";
        List<Organization> organizations = organizationRepository.findByDistrictCode(districtCode);
        Assert.assertTrue(!organizations.isEmpty());
        logger.debug("testFindByDistrictCode parameter is {}, result is {}", districtCode, organizations);
    }
}
