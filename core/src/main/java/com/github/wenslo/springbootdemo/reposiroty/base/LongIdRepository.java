package com.github.wenslo.springbootdemo.reposiroty.base;

import com.github.wenslo.springbootdemo.model.base.LongIdEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年12月04日 上午10:50
 * @description
 */
@NoRepositoryBean
public interface LongIdRepository<T extends LongIdEntity, ID extends Serializable> extends JpaRepository<T, ID>, QuerydslPredicateExecutor<T> {
    /**
     * 根据ID in 查询
     * @param ids id集合
     */
    Optional<List<T>> findByIdIn(List<ID> ids);

    /**
     * time < 创建时间
     * @param createdAtStart 时间
     */
    Optional<List<T>> findByCreatedAtAfter(Date createdAtStart);

    /**
     * time > 创建时间
     * @param createdAtEnd 时间
     */
    Optional<List<T>> findByCreatedAtBefore(Date createdAtEnd);

    /**
     * time < 修改时间
     * @param updatedAtStart 时间
     */
    Optional<List<T>> findByUpdatedAtAfter(Date updatedAtStart);

    /**
     * time > 修改时间
     * @param updatedAtEnd 时间
     */
    Optional<List<T>> findByUpdatedAtBefore(Date updatedAtEnd);

}
