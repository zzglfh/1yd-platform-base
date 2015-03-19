package com.tjcloud.platform.service.impl;

import com.tjcloud.platform.model.dictionary.ValueDictionary;
import com.tjcloud.platform.repository.ValuesRepository;
import com.tjcloud.platform.service.ValuesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ValuesServiceImp implements ValuesService {

    @Resource
    private ValuesRepository valuesRepository;

    @Override
    public ValueDictionary findValueByKey(String key) {
        ValueDictionary value = valuesRepository.findValueByKey(key);

        return value;
    }

    @Override
    public ValueDictionary save(ValueDictionary valueDictionary) {

        return valuesRepository.save(valueDictionary);
    }

}
