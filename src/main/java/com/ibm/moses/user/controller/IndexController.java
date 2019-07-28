/*
 * Copyright © 2019 bjfansr@cn.ibm.com Inc. All rights reserved
 * @package: com.ibm.moses.controller
 * @version V1.0
 */
package com.ibm.moses.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Moses *
 * @Date 2019/4/2
 */
@Controller
public class IndexController {
    @RequestMapping("/login")
    public String login() {
        return "/login";
    }
}