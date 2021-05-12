package jayfeng.com.meituan.rpc.orderserver.service.impl;

import jayfeng.com.meituan.rpc.orderserver.bean.Allowance;
import jayfeng.com.meituan.rpc.orderserver.bean.User;
import jayfeng.com.meituan.rpc.orderserver.dao.discount.AllowanceDao;
import jayfeng.com.meituan.rpc.orderserver.service.AllowanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 津贴扣除业务层
 * @author JayFeng
 * @date 2021/5/10
 */
@Slf4j
@Service
public class AllowanceServiceImpl implements AllowanceService {

    @Autowired
    private AllowanceDao allowanceDao;

    /**
     * 扣除用户津贴
     * @param user 用户
     * @param allowanceId 津贴 id
     * @param allowanceDiscount 扣除金额
     * @return 返回扣除是否成功
     */
    @Override
    public Boolean deductionUserAllowance(User user, Integer allowanceId, Float allowanceDiscount) {
        // 这里不做安全性判断了，在面向用户的 service 层，针对用户 id 利用分布式锁拦截，一个用户同一时间只能创建一个订单
        Allowance allowance = allowanceDao.findAllowanceById(allowanceId);
        log.info("deductionUserAllowance 扣除用户津贴 user: {}, allowance: {}, allowanceDiscount: {}", user, allowance, allowanceDiscount);
        Float balance = allowance.getMoney() - allowanceDiscount;
        allowanceDao.updateAllowanceMoney(allowanceId, allowance.getMoney(), System.currentTimeMillis());
        log.info("deductionUserAllowance 津贴扣除成功 allowance: {}, 余额balance: {}", allowance, balance);
        return true;
    }

}
