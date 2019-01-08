package com.github.wenslo.springbootdemo.enums.common;

import com.github.wenslo.springbootdemo.enums.BaseEnum;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2019-01-07 17:32
 * @description 操作类型
 */
public enum OperateRecordType implements BaseEnum {

    USER("用户相关操作");
    private String label;

    @Override
    public String getLabel() {
        return label;
    }


    OperateRecordType(String label) {
        this.label = label;
    }
}