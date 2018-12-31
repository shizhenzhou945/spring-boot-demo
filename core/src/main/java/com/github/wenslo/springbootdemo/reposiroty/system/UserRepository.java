package com.github.wenslo.springbootdemo.reposiroty.system;

import com.github.wenslo.springbootdemo.model.system.User;
import com.github.wenslo.springbootdemo.reposiroty.LongIdRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年11月24日 下午3:59
 * @description
 */
@Repository
public interface UserRepository extends LongIdRepository<User, Long> {
    public User findByUsername(String username);

}
