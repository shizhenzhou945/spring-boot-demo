package com.github.wenslo.springbootdemo.service.system.impl;

import com.github.wenslo.springbootdemo.condition.system.DistictCondition;
import com.github.wenslo.springbootdemo.model.system.District;
import com.github.wenslo.springbootdemo.service.base.impl.LongIdServiceImpl;
import com.github.wenslo.springbootdemo.service.system.DistrictService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2019-01-01 20:08
 * @description
 */
@Service
@Transactional(readOnly = true)
public class DistrictServiceImpl extends LongIdServiceImpl<District, DistictCondition> implements DistrictService {
}
