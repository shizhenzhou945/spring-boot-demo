package com.github.wenslo.springbootdemo.reposiroty.system;

import com.github.wenslo.springbootdemo.model.system.OperateRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2019-01-07 17:39
 * @description
 */
@Repository
public interface OperateRecordRepository extends MongoRepository<OperateRecord, String> {
}
