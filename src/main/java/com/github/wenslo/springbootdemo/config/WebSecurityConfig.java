package com.github.wenslo.springbootdemo.config;

import com.github.wenslo.springbootdemo.security.filter.CustomAuthenticationFilter;
import com.github.wenslo.springbootdemo.security.provider.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

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
//                .successHandler(mainAuthenticationSuccessHandler)
//                .failureHandler(mainAuthenticationFailureHandler)
//                .loginProcessingUrl("/login")
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
        http.addFilterAt(customAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public CustomAuthenticationFilter customAuthenticationFilter() throws Exception {
        CustomAuthenticationFilter filter = new CustomAuthenticationFilter();
        filter.setAuthenticationSuccessHandler(mainAuthenticationSuccessHandler);
        filter.setAuthenticationFailureHandler(mainAuthenticationFailureHandler);
        filter.setFilterProcessesUrl("/login");
        filter.setAuthenticationManager(super.authenticationManagerBean());
        return filter;
    }
}
