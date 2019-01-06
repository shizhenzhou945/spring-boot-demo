package com.github.wenslo.springbootdemo.condition.administration;

import com.github.wenslo.springbootdemo.condition.base.OrganizationBasicCondition;
import lombok.Data;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2019-01-06 14:05
 * @description 部门查询条件
 */
@Data
public class DepartmentCondition extends OrganizationBasicCondition {
    /** 部门名称 **/
    private String name;
    /** 父部门ID **/
    private Long parentId;
}
