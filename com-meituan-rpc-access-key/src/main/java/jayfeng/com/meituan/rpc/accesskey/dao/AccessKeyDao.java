package jayfeng.com.meituan.rpc.accesskey.dao;

import jayfeng.com.meituan.rpc.accesskey.bean.AccessKey;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 短信密钥持久层
 * @author JayFeng
 * @date 2021/4/4
 */
@Repository
public interface AccessKeyDao {

    /**
     * 查询所有密钥
     * @return 返回密钥列表
     */
    @Select("SELECT `id`, `region_id`, `access_key_id`, `secret`, `type` FROM `access_key`")
    List<AccessKey> selectAllAccessKey();

}
