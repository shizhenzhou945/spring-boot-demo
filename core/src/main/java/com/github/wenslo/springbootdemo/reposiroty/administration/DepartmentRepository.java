package com.github.wenslo.springbootdemo.reposiroty.administration;

import com.github.wenslo.springbootdemo.model.administration.Department;
import com.github.wenslo.springbootdemo.reposiroty.base.OrganizationBasicRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018-12-31 23:52
 * @description 部门
 */
@Repository
public interface DepartmentRepository extends OrganizationBasicRepository<Department, Long> {
    /**
     * 根据父部门ID批量查询
     * @param ids id集合
     * @return 子部门集合
     */
    public List<Department> findByParentDepartmentIdIn(List<Long> ids);
}
