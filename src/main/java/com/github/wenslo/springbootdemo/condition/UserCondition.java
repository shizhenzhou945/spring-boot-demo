package com.github.wenslo.springbootdemo.condition;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年12月02日 下午2:50
 * @description
 */
public class UserCondition extends BaseCondition {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
