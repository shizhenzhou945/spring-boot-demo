package com.github.wenslo.springbootdemo.util;

import com.github.wenslo.springbootdemo.enums.BaseEnum;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2019-02-24 19:42
 * @description custom jexl processing
 */
@Component
public class ExcelExpression {

    public String getLabel(Object data) {
        if (Objects.isNull(data)) return "";
        if (data instanceof Boolean) {
            boolean result = (Boolean) data;
            return result ? "是" : "否";
        }
        if (data instanceof BaseEnum) {
            BaseEnum baseEnum = (BaseEnum) data;
            return baseEnum.getLabel();
        }
        return "";

    }

    public String format(Object date) {
        if (Objects.isNull(date)) return "";
        if (date instanceof LocalDateTime) {
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime localDateTime = (LocalDateTime) date;
            return df.format(localDateTime);
        }
        if (date instanceof LocalDate) {
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = (LocalDate) date;
            return df.format(localDate);
        }
        if (date instanceof LocalTime) {
            DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm:ss");
            LocalTime localTime = (LocalTime) date;
            return df.format(localTime);
        }
        return "";
    }

}
