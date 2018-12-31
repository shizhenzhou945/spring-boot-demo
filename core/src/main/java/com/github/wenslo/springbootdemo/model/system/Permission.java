package com.github.wenslo.springbootdemo.model.system;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年12月10日 上午10:36
 * @description 权限DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Permission implements Serializable {
    /** 权限实际值 **/
    private String value;
    /** 权限描述 **/
    private String label;
    /** 是否启用 **/
    private boolean enabled = false;
    /** 所属权限组 **/
    private String group;

    public Permission(String value, String label, String group) {
        this.value = value;
        this.label = label;
        this.group = group;
    }

    public Permission(String value, String label, boolean enabled) {
        this.value = value;
        this.label = label;
        this.enabled = enabled;
    }

}
