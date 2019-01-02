package com.github.wenslo.springbootdemo.enums.common;

import com.github.wenslo.springbootdemo.enums.BaseEnum;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2019-01-02 08:54
 * @description 区域查询类型
 */
public enum DistrictType implements BaseEnum {
    PROVINCE("省"), CITY("市"), AREA("区");
    private String label;


    @Override
    public String getLabel() {
        return label;
    }


    DistrictType(String label) {
        this.label = label;
    }
}
