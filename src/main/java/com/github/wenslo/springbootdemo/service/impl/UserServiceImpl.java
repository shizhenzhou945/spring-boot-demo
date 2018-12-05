package com.github.wenslo.springbootdemo.service.impl;

import com.github.wenslo.springbootdemo.base.service.impl.BaseServiceImpl;
import com.github.wenslo.springbootdemo.condition.UserCondition;
import com.github.wenslo.springbootdemo.model.QUser;
import com.github.wenslo.springbootdemo.model.User;
import com.github.wenslo.springbootdemo.service.UserService;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年12月04日 上午11:06
 * @description
 */
@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User, UserCondition> implements UserService {

    @Override
    public Predicate toPredicate(UserCondition condition) {
        BooleanBuilder builder = new BooleanBuilder();
        QUser user = QUser.user;
        String username = condition.getUsername();
        if (StringUtils.isNoneBlank(username)) {
            builder.and(user.username.startsWith(username));
        }
        Boolean enabled = condition.getEnabled();
        if (Objects.nonNull(enabled)) {
            builder.and(user.enabled.eq(enabled));
        }
        return builder;
    }
}
