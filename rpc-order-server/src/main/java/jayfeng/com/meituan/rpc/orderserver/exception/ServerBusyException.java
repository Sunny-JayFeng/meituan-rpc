package jayfeng.com.meituan.rpc.orderserver.exception;

/**
 * 繁忙异常
 * @author JayFeng
 * @date 2021/5/10
 */
public class ServerBusyException extends RuntimeException {

    public ServerBusyException(String message) {
        super(message);
    }

}
