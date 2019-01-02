package com.github.wenslo.springbootdemo.service.system;

import com.github.wenslo.springbootdemo.condition.system.DistictCondition;
import com.github.wenslo.springbootdemo.enums.common.DistrictType;
import com.github.wenslo.springbootdemo.model.system.District;
import com.github.wenslo.springbootdemo.service.base.LongIdService;

import java.util.List;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2019-01-01 15:02
 * @description 地区
 */
public interface DistrictService extends LongIdService<District, DistictCondition> {
    /**
     * 根据类型查询地区
     * @param type 地区类型
     * @return 地区
     */
    List<District> findByType(DistrictType type);
}
