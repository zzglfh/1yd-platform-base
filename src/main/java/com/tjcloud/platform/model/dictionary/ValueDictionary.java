package com.tjcloud.platform.model.dictionary;

import com.tjcloud.platform.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "D_VALUES")
public class ValueDictionary extends BaseEntity {

    /**
     * @Fields serialVersionUID
     */

    private static final long serialVersionUID = -8289077304122541718L;

    @Column(name = "key_word")
    private String key;

    @Column(name = "val")
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
