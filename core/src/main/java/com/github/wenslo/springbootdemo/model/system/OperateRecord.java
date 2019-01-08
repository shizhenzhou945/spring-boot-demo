package com.github.wenslo.springbootdemo.model.system;

import com.github.wenslo.springbootdemo.enums.common.OperateRecordType;
import com.github.wenslo.springbootdemo.observer.event.Event;
import com.querydsl.core.annotations.QueryEntity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2019-01-07 16:56
 * @description
 */
@QueryEntity
@Document
@Data
public class OperateRecord<T> implements Event, Serializable {
    @Id
    private String id;
    /** 操作人 **/
    private User user;
    /** 操作数据 **/
    private T record;
    private OperateRecordType operateRecordType;
}
