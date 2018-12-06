package com.github.wenslo.springbootdemo.base.util;

import com.google.common.collect.Lists;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

import java.util.List;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年12月05日 上午10:00
 * @description
 */
public class PredicateUtil {
    //init in used time
    public List<Predicate> list = Lists.newArrayList();


    public BooleanBuilder toBooleanBuilder(List<Predicate> predicates) {
        BooleanBuilder builder = new BooleanBuilder();
        predicates.stream().map(builder::and);
        return builder;
    }
}
