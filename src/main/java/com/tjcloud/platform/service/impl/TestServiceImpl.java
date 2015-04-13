package com.tjcloud.platform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjcloud.platform.model.TestEntity;
import com.tjcloud.platform.model.TestEntity.TestType;
import com.tjcloud.platform.repository.TestRepository;
import com.tjcloud.platform.service.TestService;

@Service
public class TestServiceImpl implements TestService {
	
	@Autowired
	TestRepository testRepository;

	/* (non-Javadoc)
	 * @see com.tjcloud.platform.service.TestService#findByName(java.lang.String)
	 */
	@Override
	public TestEntity findByName(String name) {
		return testRepository.findByName(name);
	}

	/* (non-Javadoc)
	 * @see com.tjcloud.platform.service.TestService#findByTestType(com.tjcloud.platform.model.TestEntity.TestType)
	 */
	@Override
	public List<TestEntity> findByTestType(TestType testType) {
		return testRepository.findByTestType(testType);
	}

	/* (non-Javadoc)
	 * @see com.tjcloud.platform.service.TestService#save(com.tjcloud.platform.model.TestEntity)
	 */
	@Override
	public void save(TestEntity entity) {
		testRepository.save(entity);
		
	}

    

}
