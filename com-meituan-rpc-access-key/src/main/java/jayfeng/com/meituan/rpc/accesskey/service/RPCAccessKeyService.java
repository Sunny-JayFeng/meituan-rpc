package jayfeng.com.meituan.rpc.accesskey.service;

import jayfeng.com.meituan.rpc.accesskey.bean.AccessKey;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.List;
import java.util.Map;

/**
 * 短信密钥业务逻辑
 * @author JayFeng
 * @date 2021/4/4
 */
@DubboService(version = "1.0.2")
public interface RPCAccessKeyService {

    void initAllAccessKeyList();

    List<AccessKey> rpcGetAccessKeyListByType(Integer type);

    Map<Integer, List<AccessKey>> rpcGetAccessKeyMap();

}
