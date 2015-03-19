package com.tjcloud.platform.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tjcloud.platform.model.TestEntity;
import com.tjcloud.platform.model.TestEntity.TestType;

public interface TestRepository extends CrudRepository<TestEntity, Integer> {

	public TestEntity findByName(String name);
	
	public List<TestEntity> findByTestType(TestType testType);
}
