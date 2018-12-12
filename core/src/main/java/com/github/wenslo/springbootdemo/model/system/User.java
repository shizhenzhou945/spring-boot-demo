package com.github.wenslo.springbootdemo.model.system;

import com.github.wenslo.springbootdemo.convert.PermissionConverter;
import com.github.wenslo.springbootdemo.model.BaseIdEntity;
import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年11月24日 下午3:59
 * @description
 */
@Entity
public class User extends BaseIdEntity implements UserDetails {

    /** 用户名 **/
    @Column(name = "username")
    private String username;
    /** 密码 **/
    @Column(name = "password")
    private String password;
    /** 权限 **/
    @Column(name = "permission", length = 1024)
    @Convert(converter = PermissionConverter.class)
    private List<Permission> permission;
    /** 角色 **/
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<Role> roles;
    /** 账户是否过期 **/
    @Column(name = "account_non_expired")
    private boolean accountNonExpired;
    /** 账户是否锁定 **/
    @Column(name = "account_non_locked")
    private boolean accountNonLocked;
    /** 凭证未过期 **/
    @Column(name = "credentials_non_expired")
    private boolean credentialsNonExpired;
    /** 账户是否启用 **/
    @Column(name = "enabled")
    private boolean enabled;


    @Transient
    private Map<String, List<Permission>> permissionMap;

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Permission> getPermission() {
        return permission;
    }

    public void setPermission(List<Permission> permission) {
        this.permission = permission;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Date getCreatedAt() {
        return createdAt;
    }

    @Override
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public Date getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<String> authorities = Sets.newHashSet();
        if (!permission.isEmpty()) {
            authorities.addAll(getPermissionCollect(this.permission));
        }
        if (!roles.isEmpty()) {
            roles.forEach(it -> {
                List<Permission> rolePermissions = it.getPermission();
                if (!rolePermissions.isEmpty()) {
                    authorities.addAll(getPermissionCollect(rolePermissions));
                }
            });
        }
        return authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    public Map<String, List<Permission>> getPermissionMap() {
        return permissionMap;
    }

    public void setPermissionMap(Map<String, List<Permission>> permissionMap) {
        this.permissionMap = permissionMap;
    }

    /**
     * collect permission
     * @param permissions permissions
     * @return permission str on set
     */
    private Set<String> getPermissionCollect(List<Permission> permissions) {
        return permissions.stream().filter(Permission::isEnabled).map(Permission::getValue).collect(Collectors.toSet());
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", permission=" + permission +
                ", roles=" + roles +
                ", accountNonExpired=" + accountNonExpired +
                ", accountNonLocked=" + accountNonLocked +
                ", credentialsNonExpired=" + credentialsNonExpired +
                ", enabled=" + enabled +
                ", permissionMap=" + permissionMap +
                ", id=" + id +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
