/*
 * Copyright © 2019 bjfansr@cn.ibm.com Inc. All rights reserved
 * @package: com.ibm.moses.controller
 * @version V1.0
 */
package com.ibm.moses.user.controller;

import com.ibm.moses.user.model.UserEntity;
import com.ibm.moses.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Moses *
 * @Date 2019/4/2
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(HttpServletRequest request, UserEntity user, Model model) {
        if (userService.getUser(user)) {
            request.getSession().setAttribute("login", true);
            if ("admin".equals(user.getUsername())) {
                model.addAttribute("userList", userService.getUserList());
                return "/user/userList";
            } else {
                return "/main";
            }
        } else {
            return "/login";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().setAttribute("login", false);
        return "/login";
    }

    @RequestMapping("/getUserList")
    public String getUserList(Model model) {
        model.addAttribute("userList", userService.getUserList());
        return "/user/userList";
    }

    @RequestMapping("/getUser")
    public String getUser(long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "/user/editUser";
    }

    @RequestMapping("/toAddUser")
    public String toAddUser() {
        return "/user/addUser";
    }

    @RequestMapping("/addUser")
    public String addUser(UserEntity user, Model model) {
        userService.addUser(user);
        model.addAttribute("userList", userService.getUserList());
        return "/user/userList";
    }

    @RequestMapping("/delUser")
    public String delUser(long id, Model model) {
        userService.delUser(id);
        model.addAttribute("userList", userService.getUserList());
        return "/user/userList";
    }

    @RequestMapping("/updateUser")
    public String updateUser(UserEntity user, Model model) {
        userService.updateUser(user);
        model.addAttribute("userList", userService.getUserList());
        return "/user/userList";
    }
}