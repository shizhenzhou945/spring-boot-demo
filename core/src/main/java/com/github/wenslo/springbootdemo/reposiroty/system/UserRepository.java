package com.github.wenslo.springbootdemo.reposiroty.system;

import com.github.wenslo.springbootdemo.model.system.User;
import com.github.wenslo.springbootdemo.reposiroty.base.LongIdRepository;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年11月24日 下午3:59
 * @description
 */
@Repository
public interface UserRepository extends LongIdRepository<User, Long> {
    @EntityGraph(value = "user.organizations", type = EntityGraph.EntityGraphType.FETCH)
    public User findByUsername(String username);
}
