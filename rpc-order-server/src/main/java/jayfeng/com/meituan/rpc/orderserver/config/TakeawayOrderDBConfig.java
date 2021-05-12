package jayfeng.com.meituan.rpc.orderserver.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * 外卖订单数据源配置
 * @author JayFeng
 * @date 2021/5/12
 */
@Configuration
@MapperScan(basePackages = {"jayfeng.com.meituan.rpc.dao.order"}, sqlSessionFactoryRef = "takeawayOrderSqlSessionFactory")
public class TakeawayOrderDBConfig {

    @Autowired
    private DatabaseConfig databaseConfig;

    @Autowired
    @Qualifier("takeawayOrderDataSource")
    private DataSource takeawayOrderDataSource;

    @Bean(name = "takeawayOrderSqlSessionFactory")
    public SqlSessionFactory takeawayOrderSqlSessionFactory() throws Exception {
        return databaseConfig.getSqlSessionFactory(takeawayOrderDataSource);
    }

    @Bean(name = "takeawayOrderSqlSessionFactory")
    public SqlSessionTemplate discountSqlSessionTemplate(@Qualifier("takeawayOrderSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
