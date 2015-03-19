/**
 * 
 */
package com.tjcloud.platform.service.impl;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.apache.commons.lang.Validate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.tjcloud.platform.model.TestEntity;
import com.tjcloud.platform.model.TestEntity.TestType;

/**
 * @author zzg
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-test.xml" })
//事物，=true为回滚，一般不是特殊操作不要改...
@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=true)
@Transactional
public class TestServiceImplTest {
	


	@Autowired
	TestServiceImpl testServiceImpl;
	TestEntity test;
	
	@Before
	public void init (){
		test=new TestEntity();
		test.setName("1yd-test-test-test-test");
		test.setTestType(TestType.success);
		
	}
	@Test
	public void test() {
		testServiceImpl.save(test);
		TestEntity tmptest=testServiceImpl.findByName(test.getName());
		assertEquals(tmptest.getName(),test.getName());
	}

}
