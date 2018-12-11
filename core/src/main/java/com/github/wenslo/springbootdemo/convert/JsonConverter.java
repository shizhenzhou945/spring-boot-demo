package com.github.wenslo.springbootdemo.convert;

import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.List;
import java.util.Objects;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年12月11日 上午9:46
 * @description json to column
 */
@Converter
public class JsonConverter<T> implements AttributeConverter<List<T>, String> {

    @Autowired
    private Gson gson;

    @Override
    public String convertToDatabaseColumn(List<T> attribute) {
        if (Objects.nonNull(attribute) && !attribute.isEmpty()) {
            return gson.toJson(attribute);
        }
        return null;
    }

    @Override
    public List<T> convertToEntityAttribute(String dbData) {
        if (StringUtils.isNotBlank(dbData)) {
            return gson.fromJson(dbData, List.class);
        }
        return null;
    }
}
