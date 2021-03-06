package com.github.wenslo.springbootdemo.service.administration.impl;

import com.github.wenslo.springbootdemo.condition.administration.DepartmentCondition;
import com.github.wenslo.springbootdemo.model.administration.Department;
import com.github.wenslo.springbootdemo.reposiroty.administration.DepartmentRepository;
import com.github.wenslo.springbootdemo.service.administration.DepartmentService;
import com.github.wenslo.springbootdemo.service.base.impl.OrganizationBasicServiceImpl;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2019-01-06 14:13
 * @description 部门
 */
@Service
@Transactional(
        isolation = Isolation.SERIALIZABLE,
        propagation = Propagation.MANDATORY)
public class DepartmentServiceImpl extends OrganizationBasicServiceImpl<Department, DepartmentCondition> implements DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    @Override
    public List<Long> findChildDepartmentIds(Long id) {
        List<Long> result = Lists.newArrayList(id);
        return appendChildId(result, Lists.newArrayList(id));
    }

    private List<Long> appendChildId(List<Long> result, List<Long> toQueryIds) {
        List<Department> list = repository.findByParentDepartmentIdIn(toQueryIds);
        if (list.isEmpty()) {
            return result;
        }
        List<Long> collect = list.stream().map(Department::getId).collect(Collectors.toList());
        result.addAll(collect);
        return appendChildId(result, collect);
    }
}
