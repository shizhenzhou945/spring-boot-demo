package com.github.wenslo.springbootdemo.config;

import com.github.wenslo.springbootdemo.security.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年11月24日 下午4:24
 * @description
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MainAuthenticationProvider mainAuthenticationProvider;
    @Autowired
    private MainAuthenticationEntryPoint mainAuthenticationEntryPoint;
    @Autowired
    private MainAuthenticationSuccessHandler mainAuthenticationSuccessHandler;
    @Autowired
    private MainAuthenticationFailureHandler mainAuthenticationFailureHandler;
    @Autowired
    private MainLogoutSuccessHandler mainLogoutSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/login_page")
                .successHandler(mainAuthenticationSuccessHandler)
                .failureHandler(mainAuthenticationFailureHandler)
                .loginProcessingUrl("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .logoutSuccessHandler(mainLogoutSuccessHandler)
                .and()
                .csrf()
                .disable()
                .authenticationProvider(mainAuthenticationProvider)
                .exceptionHandling()
                .authenticationEntryPoint(mainAuthenticationEntryPoint)

        ;
    }
}
