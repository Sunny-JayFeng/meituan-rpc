package jayfeng.com.meituan.rpc.orderserver.service.impl;

import jayfeng.com.meituan.rpc.orderserver.bean.User;
import jayfeng.com.meituan.rpc.orderserver.dao.AllowanceDao;
import jayfeng.com.meituan.rpc.orderserver.service.AllowanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        log.info("deductionUserAllowance 扣除用户津贴 user: {}, allowanceId: {}, allowanceDiscount: {}", user, allowanceId, allowanceDiscount);
        return null;
    }

}
