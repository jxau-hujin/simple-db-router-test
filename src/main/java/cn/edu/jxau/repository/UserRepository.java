package cn.edu.jxau.repository;

import cn.edu.jxau.dao.IUserChangeDao;
import cn.edu.jxau.dao.IUserDao;
import cn.edu.jxau.db.router.DbContextHolder;
import cn.edu.jxau.db.router.common.Constants;
import cn.edu.jxau.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @description:
 * @author：gezellighied.h
 * @date: 2022/1/12
 */
@Repository
public class UserRepository implements IUserRepository{

    private Logger logger = LoggerFactory.getLogger(UserRepository.class);

    @Resource
    private IUserDao userDao;

    @Resource
    private IUserChangeDao userChangeDao;

    @Override
    public int insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public User queryByUserId(String userId) {
        return userDao.queryByUserId(userId);
    }

    @Override
    public int updatePassword(User user) {
        return userDao.updatePassword(user);
    }

    @Override
    public int updateModifyCount(String userId) {
        return userChangeDao.updateModifyCount(userId);
    }
}
