package com.tjcloud.platform.service;

import com.tjcloud.platform.model.dictionary.ValueDictionary;

public interface ValuesService {

    public ValueDictionary findValueByKey(String key);

    public ValueDictionary save(ValueDictionary valueDictionary);
}
