package jayfeng.com.meituan.rpc.orderserver.service;

import jayfeng.com.meituan.rpc.orderserver.bean.User;
import org.springframework.stereotype.Service;

/**
 * 红包业务层
 * @author JayFeng
 * @date 2021/5/10
 */
@Service
public interface LuckyMoneyService {

    /**
     * 扣除用户红包
     * @param user 用户 id
     * @param luckyMoneyId 红包 id
     * @return 返回扣除是否成功
     */
    Boolean deductionUserLuckyMoney(User user, Integer luckyMoneyId);

}
