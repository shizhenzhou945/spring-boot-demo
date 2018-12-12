package com.github.wenslo.springbootdemo;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.google.gson.Gson;
import org.dbunit.DataSourceBasedDBTestCase;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import javax.sql.DataSource;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年11月25日 下午12:45
 * @description 基础测试基类
 */
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaConfig.class)
@ActiveProfiles("test")
public abstract class BaseTestCase extends DataSourceBasedDBTestCase {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    protected Gson gson;
    @Autowired
    private DataSource dataSource;

    @Override
    protected DataSource getDataSource() {
        return dataSource;
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        InputStream inputStream = getClass().getResourceAsStream("/dataset.xml");
        Reader reader = new InputStreamReader(inputStream);
        return new FlatXmlDataSetBuilder().build(reader);
    }
}
