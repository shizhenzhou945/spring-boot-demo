package com.github.wenslo.springbootdemo.model.system;

import com.github.wenslo.springbootdemo.model.BaseIdEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018-12-31 17:02
 * @description 地区，采用国家统一编码
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Region extends BaseIdEntity {
    /** 编码 **/
    private String code;
    /** 名称 **/
    private String name;
    /** 父地区编码 **/
    private String parentCode;
    /** 邮政编码 **/
    private String zipCode;
}
