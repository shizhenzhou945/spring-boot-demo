package com.github.wenslo.springbootdemo.reposiroty.base;

import com.github.wenslo.springbootdemo.model.base.OrganizationBasicEntity;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2019-01-01 00:44
 * @description
 */
@NoRepositoryBean
public interface OrganizationBasicRepository<T extends OrganizationBasicEntity, C extends Serializable> extends LongIdRepository<T, C> {

    public Optional<List<T>> findByOrganizationIdOrOrganizationHeadquartersId(Long organizationId);
}
