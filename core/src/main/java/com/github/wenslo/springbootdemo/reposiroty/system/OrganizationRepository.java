package com.github.wenslo.springbootdemo.reposiroty.system;

import com.github.wenslo.springbootdemo.model.system.Organization;
import com.github.wenslo.springbootdemo.reposiroty.base.LongIdRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018-12-31 20:15
 * @description 机构
 */
@Repository
public interface OrganizationRepository extends LongIdRepository<Organization, Long> {
    //    @Query("select o from Organization o JOIN fetch o.users where o.districtCode = ?1")
    @Query("from Organization o where o.districtCode like :districtCode%")
    public List<Organization> findByDistrictCode(@Param("districtCode") String districtCode);
}
