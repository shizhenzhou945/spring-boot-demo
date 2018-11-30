package com.github.wenslo.springbootdemo.convert;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年11月30日 下午3:06
 * @description
 */
@Converter
public class StringListConverter implements AttributeConverter<List<String>, String> {

    @Override
    public String convertToDatabaseColumn(List<String> attribute) {
        if (!attribute.isEmpty()) {
            return attribute.stream().collect(Collectors.joining(","));
        }
        return null;
    }

    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        if (StringUtils.isNoneBlank(dbData)) {
            return Arrays.stream(dbData.split(",")).collect(Collectors.toList());
        }
        return Lists.newArrayList();
    }

}
