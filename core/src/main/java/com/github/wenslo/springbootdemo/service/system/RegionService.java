package com.github.wenslo.springbootdemo.service.system;

import com.github.wenslo.springbootdemo.condition.system.RegionCondition;
import com.github.wenslo.springbootdemo.model.system.Region;
import com.github.wenslo.springbootdemo.service.base.LongIdService;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2019-01-01 15:02
 * @description 地区
 */
public interface RegionService extends LongIdService<Region, RegionCondition> {

}
