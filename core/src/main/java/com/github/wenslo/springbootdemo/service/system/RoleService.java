package com.github.wenslo.springbootdemo.service.system;

import com.github.wenslo.springbootdemo.condition.system.RoleCondition;
import com.github.wenslo.springbootdemo.model.system.Role;
import com.github.wenslo.springbootdemo.service.base.LongIdService;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年12月12日 上午10:29
 * @description
 */
public interface RoleService extends LongIdService<Role, RoleCondition> {
}
