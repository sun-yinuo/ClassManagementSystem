package com.sunyinuo.user.service;

import result.Result;

/**
 * @author sunyinuo
 */
public interface RegisteredService {

    /**
     * 注册
     * @param userName 用户名
     * @param userPassword 密码
     * @param ip HttpServletRequest
     * @return 包装
     */
    Result registered (String userName, String userPassword, String ip);
}
