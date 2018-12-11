package com.github.wenslo.springbootdemo.permission.system;

import com.github.wenslo.springbootdemo.annotation.Permission;
import com.github.wenslo.springbootdemo.annotation.PermissionGroup;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年12月09日 下午7:37
 * @description
 */
@PermissionGroup
public class UserPermission {
    private static final String USER_PERMISSION = "用户权限";

    @Permission(value = "用户查看", group = USER_PERMISSION)
    public static final String USER_VIEW = "USER:VIEW";

    @Permission(value = "用户添加", group = USER_PERMISSION)
    public static final String USER_ADD = "USER:ADD";

    @Permission(value = "用户修改", group = USER_PERMISSION)
    public static final String USER_UPDATE = "USER:UPDATE";

    @Permission(value = "用户删除", group = USER_PERMISSION)
    public static final String USER_DELETE = "USER:DELETE";


}
