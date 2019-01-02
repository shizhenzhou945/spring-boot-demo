package com.github.wenslo.springbootdemo.condition.system;

import com.github.wenslo.springbootdemo.condition.base.LongIdCondition;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2019-01-02 10:53
 * @description 机构查询条件
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class OrganizationCondition extends LongIdCondition implements Serializable {
    private String name;
    private String districtCode;
}
