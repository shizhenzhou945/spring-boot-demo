package com.github.wenslo.springbootdemo.model.administration;

import com.github.wenslo.springbootdemo.model.LongIdEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018-12-31 23:45
 * @description 部门
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Department extends LongIdEntity {
    /** 部门名称 **/
    private String name;
    /** 父部门 **/
    private Long parentId;
    /** 排序码 **/
    private Long sorted;
    /** 说明 **/
    private String comment;
}
