package com.github.wenslo.springbootdemo.service.system;

import com.github.wenslo.springbootdemo.condition.system.UserCondition;
import com.github.wenslo.springbootdemo.model.system.User;
import com.github.wenslo.springbootdemo.service.base.LongIdService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年11月24日 下午3:58
 * @description
 */
@Service
@Transactional
public interface UserService extends LongIdService<User, UserCondition> {
}
