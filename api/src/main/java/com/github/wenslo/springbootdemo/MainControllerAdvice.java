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
import java.sql.SQLException;
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
    @ExceptionHandler(value = {ConstraintViolationException.class, DataIntegrityViolationException.class, SQLException.class})
    public Response constraintViolationExceptionHandler(Throwable t) {
        if (t instanceof ConstraintViolationException) {
            ConstraintViolationException ex = (ConstraintViolationException) t;
            List<String> messageList = ex.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
            String join = Strings.join(messageList, ',');
            return Response.error(join);
        }
        if (t instanceof DataIntegrityViolationException) {
            DataIntegrityViolationException dataIntegrityViolationException = (DataIntegrityViolationException) t;
            String msg = getErrorMsg(dataIntegrityViolationException);
            return populateUniqueErrorTip(msg);
        }
        if (t instanceof SQLException) {
            SQLException jdbcSQLException = (SQLException) t;
            if ("FOREIGN KEY".contains(jdbcSQLException.getMessage())) {
                return Response.error("绑定数据存在，无法进行删除或修改");
            }
        }
        logger.error("Catching exception ", t);
        return Response.error(t.getMessage());
    }

    private Response populateUniqueErrorTip(String msg) {
        String betweenString = StringUtils.substringBetween(msg, "'", "'");
        final String pattern = "{}";
        final String notExistString = "{}已经存在，请检查后重新录入！";
        String result = StringUtils.replace(notExistString, pattern, betweenString);
        return Response.error(result);
    }

    private String getErrorMsg(Throwable throwable) {
        if (throwable.getCause() != null) {
            return getErrorMsg(throwable.getCause());
        }
        return throwable.getMessage();
    }
}
