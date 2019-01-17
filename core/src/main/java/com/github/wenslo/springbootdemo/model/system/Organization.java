package com.github.wenslo.springbootdemo.model.system;

import com.github.wenslo.springbootdemo.enums.common.DeleteFlag;
import com.github.wenslo.springbootdemo.model.base.LongIdEntity;
import lombok.*;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018-12-31 16:13
 * @description 机构（学校，组织）
 */
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString(exclude = "users")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SQLDelete(sql = "update organization set delete_flag = 'DELETED' where id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "delete_flag <> 'DELETED'")
public class Organization extends LongIdEntity {
    /** 全称 **/
    private String fullName;
    /** 简称 **/
    private String name;
    /** 地区 **/
    private String districtCode;
    /** 联系地址 **/
    private String address;
    /** 联系人名称 **/
    private String contractName;
    /** 联系人电话 **/
    private String contractPhone;
    /** 是否为总部 **/
    private Boolean headquarters;
    /** 总部ID **/
    private Long headquartersId;
    @Enumerated(EnumType.STRING)
    private DeleteFlag deleteFlag;
    @Transient
    private List<User> users;

    @PreRemove
    public void preRemove() {
        this.deleteFlag = DeleteFlag.DELETED;
    }
}
