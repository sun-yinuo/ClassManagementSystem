package com.sunyinuo.user.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sunyinuo
 */
@RestController
@RequestMapping("/user/root")
public class LoginController {

    @PostMapping("/login")
    public void login(@RequestBody JSONObject jsonParam, HttpServletRequest request){
        //TODO
    }

}
