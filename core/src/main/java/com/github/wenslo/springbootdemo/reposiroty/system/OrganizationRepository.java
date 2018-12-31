package com.github.wenslo.springbootdemo.reposiroty.system;

import com.github.wenslo.springbootdemo.model.system.Organization;
import com.github.wenslo.springbootdemo.reposiroty.base.LongIdRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018-12-31 20:15
 * @description 机构
 */
@Repository
public interface OrganizationRepository extends LongIdRepository<Organization, Long> {

}
