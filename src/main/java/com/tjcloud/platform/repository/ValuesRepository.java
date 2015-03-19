package com.tjcloud.platform.repository;

import com.tjcloud.platform.model.dictionary.ValueDictionary;
import org.springframework.data.repository.CrudRepository;

public interface ValuesRepository extends CrudRepository<ValueDictionary, Integer> {

    ValueDictionary findValueByKey(String key);

}
