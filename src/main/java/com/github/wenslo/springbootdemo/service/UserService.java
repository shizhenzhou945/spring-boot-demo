package com.github.wenslo.springbootdemo.service;

import com.github.wenslo.springbootdemo.condition.UserCondition;
import com.github.wenslo.springbootdemo.model.User;
import com.github.wenslo.springbootdemo.reposiroty.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public Page<User> queryByPage(UserCondition user, Pageable pageable) {
        ExampleMatcher matcher = ExampleMatcher.matching() //构建对象
                .withMatcher("username", ExampleMatcher.GenericPropertyMatchers.startsWith()) //姓名采用“开始匹配”的方式查询
                .withIgnorePaths("id");
        User user1 = new ModelMapper().map(user, User.class);
        Example<User> ex = Example.of(user1, matcher);
//        repository.findAll(null, null);
//        Predicate predicate = user1.user.equalsIgnoreCase("dave")
//                .and(user.lastname.startsWithIgnoreCase("mathews"));
        return repository.findAll(ex, pageable);
    }
}
