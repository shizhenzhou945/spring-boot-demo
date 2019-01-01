package com.github.wenslo.springbootdemo.service.base.impl;

import com.github.wenslo.springbootdemo.condition.base.LongIdCondition;
import com.github.wenslo.springbootdemo.domain.Pageable;
import com.github.wenslo.springbootdemo.model.base.LongIdEntity;
import com.github.wenslo.springbootdemo.model.base.QLongIdEntity;
import com.github.wenslo.springbootdemo.reposiroty.base.LongIdRepository;
import com.github.wenslo.springbootdemo.service.base.LongIdService;
import com.google.common.collect.Lists;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.EntityPathBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年12月04日 上午10:43
 * @description
 */
public abstract class LongIdServiceImpl<T extends LongIdEntity, C extends LongIdCondition, Q extends EntityPathBase<T>> implements LongIdService<T, C, Q> {
    @Autowired
    protected LongIdRepository<T, Long> repository;

    private List<Predicate> conditionBuilder = Lists.newArrayList();

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
     * @return populated query condition
     */
    protected Predicate toPredicate(C condition) {
        List<Predicate> predicates = conditionBuild(condition);
        BooleanBuilder builder = new BooleanBuilder();
        predicates.forEach(builder::and);
        return builder;
    }

    /**
     * LongIdEntity condition building
     * @param condition query condition
     */
    protected List<Predicate> conditionBuild(C condition) {
        Class<T> tClass = getTClass();
        String name = tClass.getName();
        EntityPathBase<T> pathBase = new EntityPathBase<>(tClass, name);
        QLongIdEntity longIdEntity = QLongIdEntity.longIdEntity;
        Long id = condition.getId();
        if (Objects.nonNull(id)) {
            conditionBuilder.add(longIdEntity.id.eq(id));
        }
        List<Long> ids = condition.getIds();
        if (Objects.nonNull(ids) && !ids.isEmpty()) {
            conditionBuilder.add(longIdEntity.id.in(ids));
        }
        Date createdAtStart = condition.getCreatedAtStart();
        Date createdAtEnd = condition.getCreatedAtEnd();
        if (Objects.nonNull(createdAtStart) && Objects.nonNull(createdAtEnd)) {
            conditionBuilder.add(longIdEntity.createdAt.between(createdAtStart, createdAtEnd));
        } else {
            if (Objects.nonNull(createdAtStart)) {
                conditionBuilder.add(longIdEntity.createdAt.goe(createdAtStart));
            }
            if (Objects.nonNull(createdAtEnd)) {
                conditionBuilder.add(longIdEntity.updatedAt.loe(createdAtEnd));
            }
        }

        Date updatedAtStart = condition.getUpdatedAtStart();
        Date updatedAtEnd = condition.getUpdatedAtEnd();
        if (Objects.nonNull(updatedAtStart) && Objects.nonNull(updatedAtEnd)) {
            conditionBuilder.add(longIdEntity.updatedAt.between(updatedAtStart, updatedAtEnd));
        } else {
            if (Objects.nonNull(updatedAtStart)) {
                conditionBuilder.add(longIdEntity.updatedAt.goe(updatedAtStart));
            }
            if (Objects.nonNull(updatedAtEnd)) {
                conditionBuilder.add(longIdEntity.updatedAt.loe(updatedAtEnd));
            }
        }
        return conditionBuilder;
    }

    public Class<T> getTClass() {
        Class<T> tClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return tClass;
    }
}
