/*
 * Copyright © 2019 bjfansr@cn.ibm.com Inc. All rights reserved
 * @package: com.ibm.moses.user.dao
 * @version V1.0
 */
package com.ibm.moses.user.dao;

import com.ibm.moses.user.model.UserEntity;

import java.util.List;

/**
 * @author Moses *
 * @Date 2019/4/3
 */
public interface UserDao {
    UserEntity getUser(long id);

    List<UserEntity> getUserList();

    List<UserEntity> getUserList(UserEntity user);

    void addUser(UserEntity userEntity);

    void delUser(long id);

    void updateUser(UserEntity userEntity);
}