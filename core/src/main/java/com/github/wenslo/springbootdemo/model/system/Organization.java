package com.github.wenslo.springbootdemo.model.system;

import com.github.wenslo.springbootdemo.model.base.LongIdEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018-12-31 16:13
 * @description 机构（学校，组织）
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Organization extends LongIdEntity {
    /** 全称 **/
    private String fullName;
    /** 简称 **/
    private String name;
    /** 地区 **/
    private String region;
    /** 联系地址 **/
    private String address;
    /** 联系人名称 **/
    private String contractName;
    /** 联系人电话 **/
    private String contractPhone;
    /** 是否为总部 **/
    private Boolean headquarters;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<User> users;
}
