package com.github.wenslo.springbootdemo.condition.base;


import com.github.wenslo.springbootdemo.domain.Pageable;
import lombok.Getter;
import lombok.Setter;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年12月02日 下午2:50
 * @description
 */
@Getter
@Setter
public class PageCondition extends LongIdCondition {
    protected Pageable pageable;
}
