package com.github.wenslo.springbootdemo.base.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年11月25日 13:49
 * @description
 */
@MappedSuperclass
public abstract class BaseIdEntity {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @LastModifiedDate
    @Column(name = "updated_at")
    protected Date createdAt;
    @CreatedDate
    @Column(name = "created_at")
    protected Date updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"createdAt\":\"")
                .append(createdAt).append('\"');
        sb.append(",\"updatedAt\":\"")
                .append(updatedAt).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
