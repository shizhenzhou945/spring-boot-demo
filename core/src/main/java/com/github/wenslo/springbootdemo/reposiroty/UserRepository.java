package com.github.wenslo.springbootdemo.reposiroty;

import com.github.wenslo.springbootdemo.base.repository.BaseRepository;
import com.github.wenslo.springbootdemo.model.User;
import org.springframework.stereotype.Repository;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年11月24日 下午3:59
 * @description
 */
@Repository
public interface UserRepository extends BaseRepository<User, Long> {
    public User findByUsername(String username);

}
