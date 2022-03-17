package com.example.yang.conrtrollers.User;

import com.example.yang.pojo.User;
import com.example.yang.result.ResultVO;
import com.example.yang.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import static com.example.yang.result.ResultCode.*;

@RestController
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping(value = "/login", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    public ResultVO login(@RequestBody User user) {
        if (userService.login(user) == 2000){
            return new ResultVO(USER_NOT_EXIST);
        } else if (userService.login(user) == 2001) {
            return new ResultVO(USER_LOGIN_FAIL);
        }else {
            return new ResultVO(SUCCESS);
        }
    }

    @RequestMapping(value = "/register", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    public boolean register(@RequestBody User user) {
        return userService.register(user);
    }
}

