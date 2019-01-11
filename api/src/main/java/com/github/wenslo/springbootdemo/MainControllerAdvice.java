package com.github.wenslo.springbootdemo;

import com.github.wenslo.springbootdemo.domain.Response;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2019-01-05 23:49
 * @description
 */
@RestControllerAdvice
public class MainControllerAdvice {
    private static final Logger logger = LoggerFactory.getLogger(MainControllerAdvice.class);

    /**
     * 异常处理
     */
    @ExceptionHandler(value = {Throwable.class})
    public Response constraintViolationExceptionHandler(Throwable t) {
        if (t instanceof ConstraintViolationException) {
            ConstraintViolationException ex = (ConstraintViolationException) t;
            List<String> messageList = ex.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
            String join = Strings.join(messageList, ',');
            return Response.error(join);
        }
        if (t instanceof DataIntegrityViolationException) {
            DataIntegrityViolationException dataIntegrityViolationException = (DataIntegrityViolationException) t;
            String msg = dataIntegrityViolationException.getMessage();
            String betweenString = StringUtils.substringBetween(msg, "'", "'");
            final String pattern = "{}";
            final String notExistString = "{}已经存在，请检查后重新录入！";
            String result = StringUtils.replace(notExistString, pattern, betweenString);
            return Response.error(result);
        }
        return Response.SUCCESS;
    }
}
