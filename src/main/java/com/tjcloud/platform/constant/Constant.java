package com.tjcloud.platform.constant;

import java.util.regex.Pattern;

public class Constant {
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
