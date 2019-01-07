package com.github.wenslo.springbootdemo.annotation.eventbus;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2019-01-06 16:22
 * @description
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Observer {
}

