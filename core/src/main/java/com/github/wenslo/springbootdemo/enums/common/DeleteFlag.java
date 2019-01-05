package com.github.wenslo.springbootdemo.enums.common;

import com.github.wenslo.springbootdemo.enums.BaseEnum;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2019-01-05 10:49
 * @description
 */
public enum DeleteFlag implements BaseEnum {
    NORMAL("正常"), DELETED("已删除");
    private String label;


    @Override
    public String getLabel() {
        return label;
    }


    DeleteFlag(String label) {
        this.label = label;
    }
}
