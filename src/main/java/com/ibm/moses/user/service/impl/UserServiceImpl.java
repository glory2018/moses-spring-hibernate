/*
 * Copyright © 2019 bjfansr@cn.ibm.com Inc. All rights reserved
 * @package: com.ibm.moses.user.dao
 * @version V1.0
 */
package com.ibm.moses.user.service.impl;

import com.ibm.moses.user.dao.UserDao;
import com.ibm.moses.user.model.UserEntity;
import com.ibm.moses.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Moses *
 * @Date 2019/4/3
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserEntity getUser(long id) {
        return userDao.getUser(id);
    }

    @Override
    public List<UserEntity> getUserList() {
        return userDao.getUserList();
    }

    @Override
    public void addUser(UserEntity userEntity) {
        userDao.addUser(userEntity);
    }

    @Override
    public void delUser(long id) {
        userDao.delUser(id);
    }

    @Override
    public void updateUser(UserEntity userEntity) {
        userDao.updateUser(userEntity);
    }
}

