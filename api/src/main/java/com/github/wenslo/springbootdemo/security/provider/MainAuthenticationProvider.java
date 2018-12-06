package com.github.wenslo.springbootdemo.security.provider;

import com.github.wenslo.springbootdemo.domain.Response;
import com.github.wenslo.springbootdemo.security.token.CustomAuthenticationToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年11月29日 上午11:21
 * @description
 */
@Component
public class MainAuthenticationProvider implements AuthenticationProvider {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MainUserDetailsService userDetailsService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        if (Objects.equals(userDetails.getPassword(), password)) {
            CustomAuthenticationToken token = new CustomAuthenticationToken(username, password, userDetails.getAuthorities());
            token.setDetails(userDetails);
            return token;
        }
        throw new UsernameNotFoundException(Response.LOGIN_FAIL_MSG);


    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class
                .isAssignableFrom(authentication));
    }
}
