package cn.edu.jxau.service;

import cn.edu.jxau.db.router.DbContextHolder;
import cn.edu.jxau.db.router.common.Constants;
import cn.edu.jxau.db.router.strategy.IDbRouterStrategy;
import cn.edu.jxau.model.User;
import cn.edu.jxau.repository.IUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @description:
 * @author：gezellighied.h
 * @date: 2022/1/12
 */
@Service
public class UserService implements IUserService{

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @Resource
    private IUserRepository userRepository;

    @Resource
    private TransactionTemplate transactionTemplate;

    @Resource
    private Map<Constants.DbRouterStrategy, IDbRouterStrategy> dbRouterStrategyMap;

    @Override
    public int createUser(User user) {
        return userRepository.insert(user);
    }

    @Override
//    @Transactional(rollbackFor = Exception.class)
    public int updatePassword(User user) throws Exception {

        IDbRouterStrategy dbRouter = dbRouterStrategyMap.get(Constants.DbRouterStrategy.HASHCODE);
        dbRouter.doRouter(user.getUserId());
        return transactionTemplate.execute(status -> {
            try {
                int v1 = userRepository.updatePassword(user);
                if(v1 == 0) {
                    throw new Exception("更新密码失败");
                }
                int v2 = userRepository.updateModifyCount(user.getUserId());
                if(v2 == 0) {
                    throw new Exception("更新操作数失败");
                }
            } catch (Exception e) {
                logger.error("更新异常 e: {}", e);
                status.setRollbackOnly();
                return -1;
            } finally {
                dbRouter.clear();
            }
            return 1;
        });
    }

    @Override
    public User queryUserInfo(String userId) {
        return userRepository.queryByUserId(userId);
    }
}
