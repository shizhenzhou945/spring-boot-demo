package com.github.wenslo.springbootdemo.model.base;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年11月25日 13:49
 * @description
 */
@MappedSuperclass
@Setter
@Getter
public abstract class LongIdEntity {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @LastModifiedDate
    @Column(name = "updated_at")
    protected LocalDateTime createdAt;
    @CreatedDate
    @Column(name = "created_at")
    protected LocalDateTime updatedAt;
}
