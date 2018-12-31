package com.github.wenslo.springbootdemo.model.system;

import com.github.wenslo.springbootdemo.model.BaseIdEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018-12-31 16:13
 * @description 驾校（机构）
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Organization extends BaseIdEntity {
    /** 全称 **/
    private String fullName;
    /** 简称 **/
    private String name;
    /** 省 **/
    private String provinceCode;
    /** 市 **/
    private String cityCode;
    /** 区 **/
    private String areaCode;
    /** 联系地址 **/
    private String address;
    /** 联系人名称 **/
    private String contractName;
    /** 联系人电话 **/
    private String contractPhone;
    /** 该驾校下的用户信息 **/
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "organization_user", joinColumns = {@JoinColumn(name = "organization_id")}, inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private List<User> users;
}
