package jayfeng.com.meituan.rpc.orderserver.service;

import jayfeng.com.meituan.rpc.orderserver.bean.User;
import org.springframework.stereotype.Service;

@Service
public interface AllowanceService {

    /**
     * 扣除用户津贴
     * @param user 用户
     * @param allowanceId 津贴 id
     * @param allowanceDiscount 扣除金额
     * @return 返回扣除是否成功
     */
    Boolean deductionUserAllowance(User user, Integer allowanceId, Float allowanceDiscount);

}
