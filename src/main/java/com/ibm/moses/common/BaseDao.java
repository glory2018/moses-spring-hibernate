/*
 * Copyright © 2019 bjfansr@cn.ibm.com Inc. All rights reserved
 * @package: com.ibm.moses.common.dao
 * @version V1.0
 */
package com.ibm.moses.common;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Moses *
 * @Date 2019/4/4
 */
@SuppressWarnings("unchecked")
@Repository
public class BaseDao<T> {
    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.openSession();
    }

    public void executeCUD(T obj, String method) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = getSession();
            transaction = session.getTransaction();
            transaction.begin();
            switch (method) {
                case "C":
                    session.save(obj);
                    break;
                case "U":
                    session.update(obj);
                    break;
                case "D":
                    session.delete(obj);
                    break;
                default:
                    break;
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException(e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List<T> queryHQLList(String hql, Object... params) {
        Query query = getSession().createQuery(hql);
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i, params[i]);
            }
        }
        return query.list();
    }

    public List<T> executeJDBCSqlQuery(String sql, Class clazz, List<String> params) {
        NativeQuery nativeQuery = getSession().createNativeQuery(sql, clazz);
        for (int i = 0; i < params.size(); i++) {
            nativeQuery.setParameter(i, params.get(i));
        }
        return nativeQuery.getResultList();
    }

}