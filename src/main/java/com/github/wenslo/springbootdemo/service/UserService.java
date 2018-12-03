package com.github.wenslo.springbootdemo.service;

import com.github.wenslo.springbootdemo.condition.UserCondition;
import com.github.wenslo.springbootdemo.model.QUser;
import com.github.wenslo.springbootdemo.model.User;
import com.github.wenslo.springbootdemo.reposiroty.UserRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年11月24日 下午3:58
 * @description
 */
@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> getAll() {
        return repository.findAll();
    }

    public User save(User user) {
        return repository.save(user);
    }

    public Page<User> queryByPage(UserCondition condition, Pageable pageable) {
//        ExampleMatcher matcher = ExampleMatcher.matching() //构建对象
//                .withMatcher("username", ExampleMatcher.GenericPropertyMatchers.startsWith())
//                .withIgnorePaths("id");
//        User user1 = new ModelMapper().map(condition, User.class);
//        Example<User> ex = Example.of(user1, matcher);
        return repository.findAll(toPredicate(condition), pageable);
    }

    private Predicate toPredicate(UserCondition condition) {
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
