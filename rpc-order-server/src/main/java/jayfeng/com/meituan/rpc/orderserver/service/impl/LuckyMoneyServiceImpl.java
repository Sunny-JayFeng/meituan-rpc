package jayfeng.com.meituan.rpc.orderserver.service.impl;

import jayfeng.com.meituan.rpc.orderserver.bean.User;
import jayfeng.com.meituan.rpc.orderserver.bean.UserLuckyMoney;
import jayfeng.com.meituan.rpc.orderserver.dao.discount.LuckyMoneyDao;
import jayfeng.com.meituan.rpc.orderserver.dao.discount.UserLuckyMoneyDao;
import jayfeng.com.meituan.rpc.orderserver.service.LuckyMoneyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 红包扣除业务层
 * @author JayFeng
 * @date 2021/5/10
 */
@Slf4j
@Service
public class LuckyMoneyServiceImpl implements LuckyMoneyService {

    @Autowired
    private LuckyMoneyDao luckyMoneyDao;
    @Autowired
    private UserLuckyMoneyDao userLuckyMoneyDao;

    private static final Byte VALID = 0; // 红包有效状态
    private static final Byte USED = 1; // 红包已使用状态
    private static final Byte EXPIRED = 2; // 红包已过期状态

    /**
     * 扣除用户红包
     * @param user 用户 id
     * @param userLuckyMoneyId 红包 id
     * @return 返回扣除是否成功
     */
    @Override
    public Boolean deductionUserLuckyMoney(User user, Integer userLuckyMoneyId) {
        UserLuckyMoney userLuckyMoney = userLuckyMoneyDao.selectById(userLuckyMoneyId);
        log.info("deductionUserLuckMoney 扣除用户红包 user: {}, userLuckyMoney: {}", user, userLuckyMoney);
        userLuckyMoneyDao.updateUserLuckyStatus(userLuckyMoneyId, USED, System.currentTimeMillis());
        return true;
    }

}
