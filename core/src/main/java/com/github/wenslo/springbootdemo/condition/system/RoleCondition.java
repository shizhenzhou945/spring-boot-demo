package com.github.wenslo.springbootdemo.condition.system;

import com.github.wenslo.springbootdemo.condition.BaseCondition;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年12月12日 上午10:32
 * @description
 */
public class RoleCondition extends BaseCondition {
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "RoleCondition{" +
                "roleName='" + roleName + '\'' +
                ", id=" + id +
                ", pageable=" + pageable +
                '}';
    }
}
