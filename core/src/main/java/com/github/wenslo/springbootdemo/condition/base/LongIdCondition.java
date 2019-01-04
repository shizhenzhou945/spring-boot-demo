package com.github.wenslo.springbootdemo.condition.base;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2019-01-01 00:13
 * @description
 */
@Getter
@Setter
public abstract class LongIdCondition implements Serializable {
    protected Long id;
    protected List<Long> ids;
    protected LocalDateTime createdAtStart;
    protected LocalDateTime createdAtEnd;
    protected LocalDateTime updatedAtStart;
    protected LocalDateTime updatedAtEnd;

}
