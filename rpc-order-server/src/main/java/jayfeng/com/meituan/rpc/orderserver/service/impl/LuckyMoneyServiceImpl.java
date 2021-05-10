package jayfeng.com.meituan.rpc.orderserver.service.impl;

import jayfeng.com.meituan.rpc.orderserver.bean.User;
import jayfeng.com.meituan.rpc.orderserver.dao.LuckyMoneyDao;
import jayfeng.com.meituan.rpc.orderserver.service.LuckyMoneyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 红包业务层
 * @author JayFeng
 * @date 2021/5/10
 */
@Slf4j
@Service
public class LuckyMoneyServiceImpl implements LuckyMoneyService {

    @Autowired
    private LuckyMoneyDao luckyMoneyDao;

    /**
     * 扣除用户红包
     * @param user 用户 id
     * @param luckyMoneyId 红包 id
     * @return 返回扣除是否成功
     */
    @Override
    public Boolean deductionUserLuckyMoney(User user, Integer luckyMoneyId) {
        log.info("deductionUserLuckMoney 扣除用户红包 user: {}, luckyMoneyId: {}", user, luckyMoneyId);

        return true;
    }

}
