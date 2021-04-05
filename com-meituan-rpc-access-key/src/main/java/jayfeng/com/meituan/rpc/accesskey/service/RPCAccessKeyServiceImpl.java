package jayfeng.com.meituan.rpc.accesskey.service;

import jayfeng.com.meituan.rpc.accesskey.bean.AccessKey;
import jayfeng.com.meituan.rpc.accesskey.dao.AccessKeyDao;
import jayfeng.com.meituan.rpc.accesskey.service.RPCAccessKeyService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author JayFeng
 * @date 2021/4/4
 */
@Slf4j
@DubboService(version = "1.0.1")
public class RPCAccessKeyServiceImpl implements RPCAccessKeyService {

    @Autowired
    private AccessKeyDao accessKeyDao;

    private static Map<Integer, List<AccessKey>> accessKeyMap = null;

    /**
     * 初始化所有短信密钥
     */
    @Override
    @PostConstruct
    public void initAllAccessKeyList() {
        log.info("initAllAccessKeyList 初始化所有短信密钥");
        List<AccessKey> accessKeyList = accessKeyDao.selectAllAccessKey();
        accessKeyMap = accessKeyList.stream().collect(Collectors.groupingBy(AccessKey::getType));
    }

    /**
     * 根据类型获取短信密钥列表
     * @param type 类型
     * @return 返回短信密钥列表
     */
    @Override
    public List<AccessKey> rpcGetAccessKeyListByType(Integer type) {
        log.info("rpcGetAccessKeyListByType 根据类型获取短信密钥 type: {}", type);
        List<AccessKey> accessKeyList = accessKeyMap.get(type);
        log.info("rpcGetAccessKeyListByType 根据类型获取短信密钥 type: {}, accessKeyListSize: {}", type, accessKeyList.size());
        return accessKeyList;
    }

    /**
     * 获取所有的短信密钥
     * @return 返回所有的短信密钥
     */
    @Override
    public Map<Integer, List<AccessKey>> rpcGetAccessKeyMap() {
        log.info("rpcGetAccessKeyMap 获取所有的短信密钥 size: {}", accessKeyMap.size());
        return accessKeyMap;
    }


}
