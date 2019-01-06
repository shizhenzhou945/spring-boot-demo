package com.github.wenslo.springbootdemo.validator;

import com.github.wenslo.springbootdemo.annotation.validator.CardCode;
import com.github.wenslo.springbootdemo.util.IdCardVerification;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.util.Objects;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2019-01-06 15:35
 * @description
 */
public class CardCodeValidator implements ConstraintValidator<CardCode, String> {
    private static final Logger logger = LoggerFactory.getLogger(CardCodeValidator.class);

    @Override
    public void initialize(CardCode constraintAnnotation) {
    }

    @Override
    public boolean isValid(String cardCode, ConstraintValidatorContext context) {
        if (StringUtils.isNotBlank(cardCode)) {
            return true;
        } else {
            try {
                String message = IdCardVerification.IDCardValidate(cardCode);
                logger.debug("身份证号为{}，校验结果为：{}", cardCode, message);
                if (Objects.equals(IdCardVerification.VALIDITY, message)) {
                    return true;
                }
            } catch (ParseException e) {
                logger.error("身份证号转换错误", e);
                return false;
            }
            return false;
        }
    }
}
