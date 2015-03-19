package com.tjcloud.platform.constant;

import com.tjcloud.platform.utils.PropertiesReaderUtils;

import java.util.regex.Pattern;

public class Constant {

    //Constant values
    public static final String url = PropertiesReaderUtils.getProperty("cdn.url");
    public static final String verificationCodeLength = PropertiesReaderUtils.getProperty("sys.verification.code.length");
    public static final String uploadPath = PropertiesReaderUtils.getProperty("sys.upload.path");

    //Constant Pattern
    public static final Pattern mailPattern = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
    public static final Pattern mobilePattern = Pattern.compile("^((1))\\d{10}$");




    public enum UserType {
        TYPE_VIP, TYPE_NORMAL;
    }

  
    public enum UserRole {
        ROLE_USER, ROLE_ADMIN, ROLE_COACH
    }
}
