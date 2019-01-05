package com.github.wenslo.springbootdemo;

import com.github.wenslo.springbootdemo.domain.Response;
import org.apache.logging.log4j.util.Strings;
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
    /**
     * 全局异常捕捉处理
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    public Response errorHandler(ConstraintViolationException ex) {
        List<String> messageList = ex.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
        String join = Strings.join(messageList, ',');
        return Response.error(join);
    }
}
