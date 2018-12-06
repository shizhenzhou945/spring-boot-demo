package com.github.wenslo.springbootdemo.security.model;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年11月29日 下午7:39
 * @description
 */
public class AuthenticationBean {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AuthenticationBean{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
