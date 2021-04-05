package jayfeng.com.meituan.rpc.accesskey;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"jayfeng.com.meituan.rpc.accesskey.dao"})
public class ComMeituanRpcAccessKeyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComMeituanRpcAccessKeyApplication.class, args);
    }

}
