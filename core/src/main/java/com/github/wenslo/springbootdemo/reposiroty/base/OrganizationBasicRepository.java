package com.github.wenslo.springbootdemo.reposiroty.base;

import com.github.wenslo.springbootdemo.condition.base.OrganizationBasicCondition;
import com.github.wenslo.springbootdemo.model.base.OrganizationBasicEntity;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2019-01-01 00:44
 * @description
 */
@NoRepositoryBean
public interface OrganizationBasicRepository<T extends OrganizationBasicEntity, C extends OrganizationBasicCondition> extends LongIdRepository<T, C> {
}
