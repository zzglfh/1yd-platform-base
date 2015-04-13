package com.tjcloud.platform.service;

import java.util.List;

import com.tjcloud.platform.model.TestEntity;
import com.tjcloud.platform.model.TestEntity.TestType;

public interface TestService {

	public TestEntity findByName(String name);
	public void save(TestEntity entity);

	public List<TestEntity> findByTestType(TestType testType);
}
