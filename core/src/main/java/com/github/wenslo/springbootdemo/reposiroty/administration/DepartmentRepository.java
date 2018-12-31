package com.github.wenslo.springbootdemo.reposiroty.administration;

import com.github.wenslo.springbootdemo.model.administration.Department;
import com.github.wenslo.springbootdemo.reposiroty.base.LongIdRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018-12-31 23:52
 * @description 部门
 */
@Repository
public interface DepartmentRepository extends LongIdRepository<Department, Long> {

}
