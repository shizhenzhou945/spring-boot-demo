package com.github.wenslo.springbootdemo.condition;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2019-01-01 00:13
 * @description
 */
@Getter
@Setter
public class LongIdCondition implements Serializable {
    protected Long id;
    protected List<Long> ids;
    protected Date createdAtStart;
    protected Date createdAtEnd;
    protected Date updatedAtStart;
    protected Date updatedAtEnd;

}
