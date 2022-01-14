package cn.edu.jxau.repository;

import cn.edu.jxau.model.User;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author：gezellighied.h
 * @date: 2022/1/12
 */
@Repository
public interface IUserRepository {

    int insert(User user);

    User queryByUserId(String userId);

    int updatePassword(User user);

    int updateModifyCount(String userId);
}
