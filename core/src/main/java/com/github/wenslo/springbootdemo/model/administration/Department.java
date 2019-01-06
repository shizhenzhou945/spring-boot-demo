package com.github.wenslo.springbootdemo.model.administration;

import com.github.wenslo.springbootdemo.model.base.OrganizationBasicEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018-12-31 23:45
 * @description 部门
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Department extends OrganizationBasicEntity {
    /** 部门名称 **/
    private String name;
    /** 父部门 **/
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Department parentDepartment;
    /** 排序码 **/
    private Long sorted;
    /** 说明 **/
    private String comment;
}
