/*
 * Copyright © 2019 bjfansr@cn.ibm.com Inc. All rights reserved
 * @package: com.ibm.moses.user.model
 * @version V1.0
 */
package com.ibm.moses.user.model;

import javax.persistence.*;

/**
 * @author Moses *
 * @Date 2019/4/4
 */
@Entity
@Table(name = "user", schema = "test", catalog = "")
public class UserEntity {
    private long id;
    private String name;
    private String email;
    private String username;
    private String password;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
