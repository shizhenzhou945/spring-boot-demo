package com.github.wenslo.springbootdemo.cache;

import com.github.wenslo.springbootdemo.service.administration.DepartmentService;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2019-01-06 14:21
 * @description 部门id cache
 */
@Component
public class DepartmentIdCache {
    private static final Logger logger = LoggerFactory.getLogger(DepartmentIdCache.class);

    @Autowired
    private DepartmentService departmentService;

    private Cache<Long, List<Long>> cache = CacheBuilder.newBuilder().expireAfterWrite(12, TimeUnit.HOURS).build();

    /**
     * @param key   父部门ID
     * @param value 子部门ID集合
     */
    public void put(Long key, List<Long> value) {
        if (Objects.nonNull(key) && Objects.nonNull(value)) {
            cache.put(key, value);
        } else {
            throw new IllegalArgumentException("Key and value are must not be null!");
        }
    }

    /**
     * @param key 父部门
     * @return 子部门ID集合
     */
    public List<Long> get(Long key) {
        if (Objects.nonNull(key)) {
            List<Long> present = cache.getIfPresent(key);
            if (Objects.isNull(present)) {
                List<Long> ids = departmentService.findChildDepartmentIds(key);
                this.put(key, ids);
                return ids;
            }
            return present;
        }
        throw new IllegalArgumentException("Key must not be null!");
    }

    /**
     * 部门ID缓存移除
     * @param key 被移除的key
     */
    public void remove(Long key) {
        if (Objects.nonNull(key)) {
            List<Long> ids = this.get(key);
            logger.debug("移除的部门ID数量为：{}", ids);
            cache.invalidate(ids);
        } else {
            throw new IllegalArgumentException("Key must not be null!");
        }
    }

    /**
     * 部门ID缓存批量移除
     * @param keys 被移除的key集合
     */
    public void remove(List<Long> keys) {
        if (Objects.nonNull(keys) && !keys.isEmpty()) {
            cache.invalidateAll(keys);
        } else {
            throw new IllegalArgumentException("Key must not be null and not empty!");
        }
    }
}
