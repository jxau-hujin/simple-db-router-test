package cn.edu.jxau.service;

import cn.edu.jxau.model.User;

/**
 * @description:
 * @author：gezellighied.h
 * @date: 2022/1/12
 */
public interface IUserService {

    int createUser(User user);

    int updatePassword(User user) throws Exception;

    User queryUserInfo(String userId);
}
