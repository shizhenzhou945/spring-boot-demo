package com.github.wenslo.springbootdemo.condition.base;

import lombok.Getter;
import lombok.Setter;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2019-01-01 00:48
 * @description 机构查询条件
 */
@Getter
@Setter
public class OrganizationBasicCondition extends PageCondition {
    private Long organizationId;
}
