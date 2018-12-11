package com.github.wenslo.springbootdemo.convert;

import com.github.wenslo.springbootdemo.model.system.Permission;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
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
public class PermissionConverter implements AttributeConverter<List<Permission>, String> {

    @Autowired
    private Gson gson;

    @Override
    public String convertToDatabaseColumn(List<Permission> attribute) {
        if (Objects.nonNull(attribute) && !attribute.isEmpty()) {
            return gson.toJson(attribute);
        }
        return null;
    }

    @Override
    public List<Permission> convertToEntityAttribute(String dbData) {
        if (StringUtils.isNotBlank(dbData)) {
            return gson.fromJson(dbData,
                    new TypeToken<List<Permission>>() {
                    }.getType());
        }
        return null;
    }
}
