package com.github.wenslo.springbootdemo.model.system;

import com.github.wenslo.springbootdemo.convert.PermissionConverter;
import com.github.wenslo.springbootdemo.model.BaseIdEntity;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import java.util.List;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年11月30日 下午3:01
 * @description
 */
@Entity
public class Role extends BaseIdEntity {
    @Column(name = "role_name")
    private String roleName;
    @Column(name = "permission", length = 1024)
    @Convert(converter = PermissionConverter.class)
    private List<Permission> permission;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<Permission> getPermission() {
        return permission;
    }

    public void setPermission(List<Permission> permission) {
        this.permission = permission;
    }
}
