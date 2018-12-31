package com.github.wenslo.springbootdemo.reposiroty.system;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.wenslo.springbootdemo.BaseTestCase;
import org.junit.Ignore;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018-12-31 21:54
 * @description
 */
@DatabaseSetup(value = "/dataset.xml")
@Ignore
public class OrganizationRepositoryTest extends BaseTestCase {

    @Autowired
    private OrganizationRepository organizationRepository;
    @Autowired
    private UserRepository userRepository;


}
