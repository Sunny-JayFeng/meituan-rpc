package jayfeng.com.meituan.rpc.orderserver.service;

import jayfeng.com.meituan.rpc.orderserver.bean.Order;
import jayfeng.com.meituan.rpc.orderserver.bean.User;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.concurrent.ExecutionException;

@DubboService(version = "1.0.0")
public interface OrderService {

    Boolean createOrder(Order order, User user) throws ExecutionException, InterruptedException;

}
