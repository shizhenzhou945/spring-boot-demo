package com.github.wenslo.springbootdemo.enums;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2019-02-24 16:59
 * @description
 */
public enum ExcelPattern implements BaseEnum {
    xls("03"), xlsx("07");
    private String label;

    @Override
    public String getLabel() {
        return label;
    }

    ExcelPattern(String label) {
        this.label = label;
    }
}