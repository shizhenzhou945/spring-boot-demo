package com.github.wenslo.springbootdemo.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年12月04日 上午10:50
 * @description
 */
@NoRepositoryBean
public interface BaseRepository<T, ID> extends JpaRepository<T, ID>, QuerydslPredicateExecutor<T> {
}
