package com.github.wenslo.springbootdemo.security.token;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年11月30日 下午7:46
 * @description
 */
public class CustomAuthenticationToken extends UsernamePasswordAuthenticationToken {

    //TODO more field

    public CustomAuthenticationToken(Object principal, Object credentials) {
        super(principal, credentials);
    }

    public CustomAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }

}
