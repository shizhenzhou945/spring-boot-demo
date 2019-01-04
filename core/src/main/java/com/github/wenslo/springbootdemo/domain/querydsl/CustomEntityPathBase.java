package com.github.wenslo.springbootdemo.domain.querydsl;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathInits;

import javax.annotation.Nullable;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2019-01-01 18:41
 * @description 自定义通用EntityPathBase
 */
public class CustomEntityPathBase<T> extends EntityPathBase<T> {
    private static final PathInits INITS = PathInits.DIRECT2;
    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);
    public final com.github.wenslo.springbootdemo.model.system.QOrganization organization =
            new com.github.wenslo.springbootdemo.model.system.QOrganization(forProperty("organization"));


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
