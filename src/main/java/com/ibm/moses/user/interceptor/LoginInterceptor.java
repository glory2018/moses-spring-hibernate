/*
 * Copyright © 2019 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.ibm.moses.user.interceptor.LoginInterceptor
 * @version V1.0
 */
package com.ibm.moses.user.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Moses
 * @date 2019/7/28
 */
public class LoginInterceptor implements HandlerInterceptor {
    static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
    private List<String> excludedUrls;

    /**
     * 在DispatcherServlet完全处理完请求后被调用
     * 当拦截器抛出异常时,依然会从当前拦截器往回执行所的拦截器的afterCompletion()
     */
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception exception)
            throws Exception {
    }

    //在业务处理器处理请求执行完成后,生成视图之前执行的动作
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
    }

    /**
     * 在业务处理器处理请求之前被调用
     * 如果返回false 则退出本拦截器，本拦截器后面的postHandle与afterCompletion不再执行
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        String requestUri = request.getRequestURI();
        for (String url : excludedUrls) {
            if (requestUri.contains(url)) {
                return true;
            }
        }
        HttpSession session = request.getSession();
        Boolean login = (Boolean) session.getAttribute("login");
        if (login == null || !login) {
            logger.info("Pedirect to login page");
            response.sendRedirect(request.getContextPath() + "/login.form");
        }
        return true;
    }

    public void setExcludedUrls(List<String> excludedUrls) {
        this.excludedUrls = excludedUrls;
    }
}
