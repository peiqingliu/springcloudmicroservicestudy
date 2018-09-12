package com.liupeiqing.spring.cloud.dao.impl;

import com.liupeiqing.spring.cloud.dao.UserDaoCustom;
import com.liupeiqing.spring.cloud.domain.User;

/**
 * @author liupeiqing
 * @data 2018/7/24 9:41
 */
public class UserRepositoryImpl implements UserDaoCustom {

    @Override
    public User findUserByName() {
        return null;
    }

    @Override
    public String sayHello() {
        return "helloworld!";
    }
}
