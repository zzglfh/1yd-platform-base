package com.tjcloud.platform.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;


/**
 * test
 * @author zzg
 *
 */
@Entity(name="test")
public class TestEntity extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	
	@Column(name = "test_type")
	@Enumerated(EnumType.STRING)
	private TestType testType;
	
	public enum TestType{
		error,success
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the testType
	 */
	public TestType getTestType() {
		return testType;
	}

	/**
	 * @param testType the testType to set
	 */
	public void setTestType(TestType testType) {
		this.testType = testType;
	}
	
}
