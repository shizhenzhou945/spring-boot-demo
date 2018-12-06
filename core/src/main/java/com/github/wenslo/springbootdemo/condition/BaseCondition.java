package com.github.wenslo.springbootdemo.condition;


import com.github.wenslo.springbootdemo.domain.Pageable;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年12月02日 下午2:50
 * @description
 */
public class BaseCondition {
    protected Long id;
    protected Pageable pageable;

    public Pageable getPageable() {
        return pageable;
    }

    public void setPageable(Pageable pageable) {

        this.pageable = pageable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
