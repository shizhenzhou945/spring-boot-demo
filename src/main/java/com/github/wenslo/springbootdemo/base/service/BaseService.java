package com.github.wenslo.springbootdemo.base.service;

import com.github.wenslo.springbootdemo.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年12月04日 上午10:39
 * @description
 */
public interface BaseService<T, C> {
    public T get(Long id);

    public List<T> getAll();

    public T save(T entity);

    public List<T> save(Iterable<T> entities);

    public void remove(Long id);

    public void remove(T entity);

    public void remove(Iterable<T> entities);

    public Page<T> getByCondition(C condition, Pageable pageable);

    public List<T> getByCondition(C condition);

    public List<T> getByCondition(C condition, Sort sort);
}
