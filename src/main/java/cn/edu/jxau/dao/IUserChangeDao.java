package cn.edu.jxau.dao;

import cn.edu.jxau.db.router.annotation.DbRouter;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description:
 * @author：gezellighied.h
 * @date: 2022/1/13
 */
@Mapper
public interface IUserChangeDao {

    @DbRouter(splitKey = "userId")
    int updateModifyCount(String userId);
}
