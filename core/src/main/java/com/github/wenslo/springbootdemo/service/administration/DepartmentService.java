package com.github.wenslo.springbootdemo.service.administration;

import com.github.wenslo.springbootdemo.condition.administration.DepartmentCondition;
import com.github.wenslo.springbootdemo.model.administration.Department;
import com.github.wenslo.springbootdemo.service.base.OrganizationBasicService;

import java.util.List;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2019-01-06 14:04
 * @description 部门查询条件
 */
public interface DepartmentService extends OrganizationBasicService<Department, DepartmentCondition> {
    /**
     * 根据部门ID查询子部门ID集合
     * @param id 父部门ID
     * @return 子部门ID集合
     */
    public List<Long> findChildDepartmentIds(Long id);
}
