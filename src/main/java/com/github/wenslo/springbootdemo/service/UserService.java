package com.github.wenslo.springbootdemo.service;

import com.github.wenslo.springbootdemo.condition.UserCondition;
import com.github.wenslo.springbootdemo.model.User;
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
public interface UserService extends BaseService<User, UserCondition> {
}
