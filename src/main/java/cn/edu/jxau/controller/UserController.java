package cn.edu.jxau.controller;

import cn.edu.jxau.model.User;
import cn.edu.jxau.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author：gezellighied.h
 * @date: 2022/1/12
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/updatePassword")
    public String updatePassword(User user) throws Exception {
        return "" + userService.updatePassword(user);
    }

    @RequestMapping("/queryUserInfo")
    public String queryUserInfo(String userId) {
        return userService.queryUserInfo(userId).toString();
    }

    @RequestMapping("/createUser")
    public String createUser(User user) {
        return "" + userService.createUser(user);
    }
}
