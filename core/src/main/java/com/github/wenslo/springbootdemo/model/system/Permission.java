package com.github.wenslo.springbootdemo.model.system;

import java.io.Serializable;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年12月10日 上午10:36
 * @description 权限DTO
 */
public class Permission implements Serializable {
    /** 权限实际值 **/
    private String value;
    /** 权限描述 **/
    private String label;
    /** 是否启用 **/
    private boolean enabled = false;
    /** 所属权限组 **/
    private String group;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
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

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Permission() {
    }

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

    @Override
    public String toString() {
        return "Permission{" +
                "value='" + value + '\'' +
                ", label='" + label + '\'' +
                ", enabled=" + enabled +
                ", group=" + group +
                '}';
    }
}
