package com.tjcloud.platform.utils.service;

import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPasswordSaltSource implements SaltSource {

    @Override
    public Object getSalt(UserDetails user) {
        return SecurityUtil.USER_PASSWORD_SALT_PREFIX + user.getUsername();
    }

}
