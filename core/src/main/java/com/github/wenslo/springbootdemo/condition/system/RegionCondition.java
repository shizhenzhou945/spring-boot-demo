package com.github.wenslo.springbootdemo.condition.system;

import com.github.wenslo.springbootdemo.condition.base.LongIdCondition;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2019-01-01 20:07
 * @description
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RegionCondition extends LongIdCondition {
    private String name;
}
