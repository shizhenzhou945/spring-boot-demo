package com.github.wenslo.springbootdemo.enums.common;

import com.github.wenslo.springbootdemo.enums.BaseEnum;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年12月10日 上午10:46
 * @description 通用枚举  是否
 */
public enum IsFlag implements BaseEnum {
    NO("否"), YES("是");
    private String label;


    @Override
    public String getLabel() {
        return label;
    }


    IsFlag(String label) {
        this.label = label;
    }
}
