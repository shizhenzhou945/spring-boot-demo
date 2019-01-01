package com.github.wenslo.springbootdemo.domain.querydsl;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathInits;

import javax.annotation.Nullable;
import java.util.Date;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2019-01-01 18:41
 * @description 自定义EntityPathBase
 */
public class CustomEntityPathBase<T> extends EntityPathBase<T> {

    public final DateTimePath<Date> createdAt = createDateTime("createdAt", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.util.Date> updatedAt = createDateTime("updatedAt", java.util.Date.class);

    public CustomEntityPathBase(Class<? extends T> type, String variable) {
        super(type, variable);
    }

    public CustomEntityPathBase(Class<? extends T> type, PathMetadata metadata) {
        super(type, metadata);
    }

    public CustomEntityPathBase(Class<? extends T> type, PathMetadata metadata, @Nullable PathInits inits) {
        super(type, metadata, inits);
    }

}
