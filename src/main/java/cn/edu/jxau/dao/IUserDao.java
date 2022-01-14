package cn.edu.jxau.dao;

import cn.edu.jxau.db.router.annotation.DbRouter;
import cn.edu.jxau.db.router.common.Constants;
import cn.edu.jxau.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description:
 * @author：gezellighied.h
 * @date: 2022/1/12
 */
@Mapper
@DbRouter(needSplitTable = true)
public interface IUserDao {

    @DbRouter(splitKey = "userId")
    int insert(User user);

    @DbRouter(splitKey = "userId")
    int updatePassword(User user);

    @DbRouter(splitKey = "userId", operationType = Constants.DataSourceType.READ, loadBalance = Constants.LoadBalance.RANDOM)
    User queryByUserId(String userId);
}
