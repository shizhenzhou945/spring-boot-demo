package com.github.wenslo.springbootdemo.model.system;

import com.github.wenslo.springbootdemo.convert.StringListConverter;
import com.github.wenslo.springbootdemo.model.base.OrganizationBasicEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年11月30日 下午3:01
 * @description
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Role extends OrganizationBasicEntity {
    /** 角色名称 **/
    @NotEmpty
    @Column(name = "name", unique = true, length = 128)
    private String name;
    /** 角色描述 **/
    private String description;
    /** 角色是否启用 **/
    private boolean enabled;
    /** 角色权限 **/
    @Column(name = "permission", length = 1024)
    @Convert(converter = StringListConverter.class)
    private List<String> permission;
}
