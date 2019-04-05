/*
 * Copyright © 2019 bjfansr@cn.ibm.com Inc. All rights reserved
 * @package: com.ibm.moses.user.dao
 * @version V1.0
 */
package com.ibm.moses.user.dao.impl;

import com.ibm.moses.common.BaseDao;
import com.ibm.moses.user.dao.UserDao;
import com.ibm.moses.user.model.UserEntity;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Moses *
 * @Date 2019/4/3
 */
@Repository
public class UserDaoImpl extends BaseDao<UserEntity> implements UserDao {
    @Override
    public UserEntity getUser(long id) {
        String hql = "from UserEntity p where p.id = ?0";
        return queryHQLList(hql, id).get(0);
    }

    @Override
    public List<UserEntity> getUserList() {
        String hql = "from UserEntity";
        return queryHQLList(hql);
    }

    @Override
    public void addUser(UserEntity userEntity) {
        executeCUD(userEntity, "C");
    }

    @Override
    public void delUser(long id) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(id);
        executeCUD(userEntity, "D");
    }

    @Override
    public void updateUser(UserEntity userEntity) {
        executeCUD(userEntity, "U");
    }
}

