package com.github.wenslo.springbootdemo.model.system;

import com.github.wenslo.springbootdemo.convert.PermissionConverter;
import com.github.wenslo.springbootdemo.model.base.OrganizationBasicEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
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
    private String name;
    @Column(name = "permission", length = 1024)
    @Convert(converter = PermissionConverter.class)
    private List<Permission> permission;

}
