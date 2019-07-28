/*
 * Copyright © 2019 bjfansr@cn.ibm.com Inc. All rights reserved
 * @package: com.ibm.moses.user.dao
 * @version V1.0
 */
package com.ibm.moses.user.service;

import com.ibm.moses.user.model.UserEntity;

import java.util.List;

/**
 * @author Moses *
 * @Date 2019/4/3
 */
public interface UserService {
    UserEntity getUser(long id);

    List<UserEntity> getUserList();

    Boolean getUser(UserEntity user);

    void addUser(UserEntity userEntity);

    void delUser(long id);

    void updateUser(UserEntity userEntity);
}