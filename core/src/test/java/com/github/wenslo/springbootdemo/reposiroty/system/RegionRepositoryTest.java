package com.github.wenslo.springbootdemo.reposiroty.system;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.wenslo.springbootdemo.BaseTestCase;
import com.github.wenslo.springbootdemo.model.system.Region;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@DatabaseSetup(value = "/dataset.xml")
public class RegionRepositoryTest extends BaseTestCase {

    @Autowired
    private RegionRepository regionRepository;

    @Test
    public void testFindByCodeLength() {
        Integer length = 2;
        logger.debug("testFindByCodeLength , length is {}", length);
        Optional<List<Region>> optional = regionRepository.findByCodeLength(length);
        List<Region> regions = optional.orElse(null);
        Assert.assertNotNull(regions);
        Assert.assertTrue(!regions.isEmpty());
        logger.debug("testFindByCodeLength result is {} ", gson.toJson(regions));
    }

    @Test
    public void testFindByParentCodeIsNull() {
        Region region = regionRepository.findByParentCodeIsNull().orElse(null);
        Assert.assertNotNull(region);
        logger.debug("testFindByParentCodeIsNull result is {}", gson.toJson(region));
    }


}