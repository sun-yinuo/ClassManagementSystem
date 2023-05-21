package com.sunyinuo.user.service.impl;

import com.sunyinuo.user.model.User;
import com.sunyinuo.user.service.LoginService;
import com.sunyinuo.user.service.db.impl.UserServiceImpl;
import com.sunyinuo.user.utils.regex.SqlRegex;
import org.springframework.stereotype.Service;
import result.Result;
import result.ResultEnum;
import result.ResultUtil;

/**
 * 登陆业务逻辑层实现类
 * @author sunyinuo
 */
@Service
public class LoginServiceImpl implements LoginService {
    //private final HashMap<String,Object> userInfo = new HashMap<>();
    private final UserServiceImpl userService;

    public LoginServiceImpl(UserServiceImpl userService) {
        this.userService = userService;
    }

    /**
     * 登陆
     * @param userName     用户名
     * @param userPassword 密码
     * @return code
     */
    @Override
    public Result login(String userName, String userPassword, String ip) {
        User userList = userService.getUserByName(userName);

        //sql注入检查部分
        if (SqlRegex.sqlRegex(userName) || SqlRegex.sqlRegex(userPassword)){
            return ResultUtil.result(ResultEnum.SERVER_ERROR.getCode(),"SQL注入规则过滤触发");
        }

        if (userList != null){
            //登陆成功
            if (userName.equals(userList.getUserName()) && userPassword.equals(userList.getUserPassword())) {

                //userInfo.put("userName",userList.getUserName());
                //userInfo.put("userId",userList.getId());
                //TODO(v2) cookie

                return ResultUtil.result(ResultEnum.SUCCESS.getCode(),"登录成功");
            }
            if (!userPassword.equals(userList.getUserPassword())){
                return ResultUtil.result(ResultEnum.SERVER_ERROR.getCode(),"用户名或密码错误");
            }
            if (!userName.equals(userList.getUserName())){
                return ResultUtil.result(ResultEnum.SERVER_ERROR.getCode(),"用户名或密码错误");
            }
        }
        if (userList == null){
            return ResultUtil.result(ResultEnum.SERVER_ERROR.getCode(),"用户名或密码错误");
        }
        return null;
    }
}
