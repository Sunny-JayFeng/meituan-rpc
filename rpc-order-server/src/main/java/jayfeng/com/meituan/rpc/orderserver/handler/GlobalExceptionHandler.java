package jayfeng.com.meituan.rpc.orderserver.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * 全局异常处理
 * @author JayFeng
 * @date 2021/5/10
 */
@Slf4j
@RestController
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Boolean handler(Exception e) {

        return true;
    }

}
