/**
 * 
 */
package com.tjcloud.platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tjcloud.platform.model.TestEntity;
import com.tjcloud.platform.service.TestService;
import com.tjcloud.platfrom.utils.model.gyms.Test;

/**
 * @author zzg
 *
 */
@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	TestService testService;
	
	@RequestMapping(method = RequestMethod.GET)
	public Test seach(@RequestParam(value = "name") String name){
		TestEntity testEntity=testService.findByName(name);
		return testEntity.toTest();
	}
}
