package com.github.wenslo.springbootdemo.reposiroty.system;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.wenslo.springbootdemo.MongoTestCase;
import com.github.wenslo.springbootdemo.model.system.OperateRecord;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2019-01-07 17:42
 * @description
 */
@DatabaseSetup(value = "/dataset.xml")
public class OperateRecordRepositoryTest extends MongoTestCase {
    @Autowired
    private OperateRecordRepository operateRecordRepository;

    @Test
    public void testFindByDistrictCode() {
        List<OperateRecord> organizations = operateRecordRepository.findAll();
        logger.debug(" result is {}", organizations);
    }

}
