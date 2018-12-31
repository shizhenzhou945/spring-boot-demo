package com.github.wenslo.springbootdemo.service;

import com.github.wenslo.springbootdemo.condition.LongIdCondition;
import com.github.wenslo.springbootdemo.domain.Pageable;
import com.github.wenslo.springbootdemo.model.LongIdEntity;
import com.github.wenslo.springbootdemo.reposiroty.LongIdRepository;
import com.google.common.collect.Lists;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年12月04日 上午10:43
 * @description
 */
public abstract class BaseServiceImpl<T extends LongIdEntity, C extends LongIdCondition> implements BaseService<T, C> {
    @Autowired
    protected LongIdRepository<T, Long> repository;

    @Override
    public T get(Long id) {
        return repository.getOne(id);
    }

    @Override
    public List<T> getAll() {
        return repository.findAll();
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public List<T> save(Iterable<T> entities) {
        return repository.saveAll(entities);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void remove(T entity) {
        repository.delete(entity);
    }

    @Override
    public void remove(Iterable<T> entities) {
        repository.deleteAll(entities);
    }

    @Override
    public Page<T> getByCondition(C condition, Pageable pageable) {
        return repository.findAll(toPredicate(condition), pageable);
    }

    @Override
    public List<T> getByCondition(C condition) {
        return this.getByCondition(condition, Sort.by("id"));
    }

    @Override
    public List<T> getByCondition(C condition, Sort sort) {
        return Lists.newArrayList(repository.findAll(toPredicate(condition), sort));
    }

    /**
     * The page list query condition populate,so far , use BooleanBuilder ,if we have any batter method , try replace it
     * @param condition query condition
     * @return
     */
    protected abstract Predicate toPredicate(C condition);
}
