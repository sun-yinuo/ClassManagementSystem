package com.sunyinuo.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.sunyinuo.user.service.impl.RegisteredServiceImpl;
import com.sunyinuo.user.utils.ip.GetIp;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import result.Result;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sunyinuo
 */
@RestController
@RequestMapping("/user/root")
public class RegisteredController {

    public final RegisteredServiceImpl registeredService;

    public RegisteredController(RegisteredServiceImpl registeredService) {
        this.registeredService = registeredService;
    }

    @PostMapping("/registered")
    public Result registered(@RequestBody JSONObject jsonParam, HttpServletRequest request){
        String userName = (String) jsonParam.get("username");
        String userPassword = (String) jsonParam.get("password");
        String ip = GetIp.getIpAddress(request);
        System.out.println(ip);
        return registeredService.registered(userName,userPassword,ip);
    }
}
