package com.github.wenslo.springbootdemo.domain;

import java.io.Serializable;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年12月10日 下午2:58
 * @description
 */
public class SimpleEnum implements Serializable {
    private Integer origin;
    private String value;
    private String label;

    public SimpleEnum() {
    }

    public Integer getOrigin() {
        return origin;
    }

    public void setOrigin(Integer origin) {
        this.origin = origin;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public SimpleEnum(Integer origin, String value, String label) {
        this.origin = origin;
        this.value = value;
        this.label = label;
    }

    @Override
    public String toString() {
        return "SimpleEnum{" +
                "origin=" + origin +
                ", value='" + value + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}
