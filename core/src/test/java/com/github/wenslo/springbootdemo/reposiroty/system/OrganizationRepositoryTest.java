package com.github.wenslo.springbootdemo.reposiroty.system;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.wenslo.springbootdemo.BaseTestCase;
import com.github.wenslo.springbootdemo.enums.common.DeleteFlag;
import com.github.wenslo.springbootdemo.model.system.Organization;
import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

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
        List<Organization> organizations = organizationRepository.findByDistrictCode(districtCode).orElse(Lists.newArrayList());
        Assert.assertTrue(!organizations.isEmpty());
        logger.debug("testFindByDistrictCode parameter is {}, result is {}", districtCode, organizations);
    }

    @Test
    public void testDelete() {
        Long id = -1L;
        organizationRepository.deleteById(id);
        Organization organization = organizationRepository.findById(id).orElse(null);
        Assert.assertTrue(Objects.isNull(organization));
        Organization organization2 = organizationRepository.findByIdAndDeleteFlag(id, DeleteFlag.DELETED).orElse(null);
        Assert.assertTrue(Objects.isNull(organization2));
        List<Organization> list = organizationRepository.findAll();
        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void testFindByIdAndDeleteFlag() {
        Long id = -2L;
        DeleteFlag deleteFlag = DeleteFlag.DELETED;
        Organization organization = organizationRepository.findByIdAndDeleteFlag(id, deleteFlag).orElse(null);
        Assert.assertTrue(Objects.isNull(organization));
    }

    @Test
    public void testFindByHeadquartersId() throws InterruptedException {
        Long headquartersId = null;
        logger.debug("findByHeadquartersId is begin");
        CompletableFuture<List<Organization>> future = organizationRepository.findByHeadquartersId(headquartersId);
        future.thenAccept(it -> {
            logger.debug("async completableFuture is complete");
        });
        logger.debug("Invoked findByHeadquartersId ");
        Thread.sleep(500);
    }
}
