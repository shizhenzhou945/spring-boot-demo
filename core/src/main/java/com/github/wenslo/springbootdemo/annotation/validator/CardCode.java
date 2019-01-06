package com.github.wenslo.springbootdemo.annotation.validator;

import com.github.wenslo.springbootdemo.validator.CardCodeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2019-01-06 15:31
 * @description 身份证号验证注解
 */
@Target({FIELD, METHOD, PARAMETER, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = CardCodeValidator.class)
@Documented
public @interface CardCode {
    String message() default "身份证号校验错误，请输入正确身份证号！";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
