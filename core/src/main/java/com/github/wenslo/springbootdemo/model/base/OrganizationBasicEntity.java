package com.github.wenslo.springbootdemo.model.base;

import com.github.wenslo.springbootdemo.model.system.Organization;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2019-01-01 00:30
 * @description 机构实体基类
 */
@MappedSuperclass
@Setter
@Getter
//@Inheritance
public abstract class OrganizationBasicEntity extends LongIdEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id")
    private Organization organization;
}
