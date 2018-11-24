package com.github.wenslo.springbootdemo.domain;

import java.io.Serializable;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年11月24日 下午4:04
 * @description
 */
public class Response implements Serializable {
    private static final long serialVersionUID = 7170260094219472188L;
    private Object ob;

    public Object getOb() {
        return ob;
    }

    public void setOb(Object ob) {
        this.ob = ob;
    }
}
