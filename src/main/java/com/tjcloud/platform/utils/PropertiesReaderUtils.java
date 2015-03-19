package com.tjcloud.platform.utils;

import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class PropertiesReaderUtils {

    private static Logger logger = LoggerFactory.getLogger(PropertiesReaderUtils.class);

    private static Properties APIProps;

    /**
     * Setup properties
     */
    static {

        APIProps = new Properties();
        try {

            logger.debug("loading 租户配置文件");
            APIProps.load(PropertiesReaderUtils.class.getClassLoader().getResourceAsStream("system.properties"));

            if (APIProps.getProperty("properties.version").equals("release")) {
                APIProps.load(PropertiesReaderUtils.class.getClassLoader().getResourceAsStream("release.properties"));
            } else if (APIProps.getProperty("properties.version").equals("develop")) {
                APIProps.load(PropertiesReaderUtils.class.getClassLoader().getResourceAsStream("develop.properties"));
            } else if (APIProps.getProperty("properties.version").equals("product")) {
                APIProps.load(PropertiesReaderUtils.class.getClassLoader().getResourceAsStream("product.properties"));
            } else {
                APIProps.load(PropertiesReaderUtils.class.getClassLoader().getResourceAsStream("develop.properties"));
            }

        } catch (Exception e) {
            logger.error("不能载入租户API配置文件");
            e.printStackTrace();
        }
    }

    /**
     * Get value by key
     *
     * @param key
     * @return
     */
    public static String getProperty(String key) {
        Validate.notEmpty(key);

        String value = APIProps.getProperty(key);

        Validate.notEmpty(value);
        return value;
    }

}
