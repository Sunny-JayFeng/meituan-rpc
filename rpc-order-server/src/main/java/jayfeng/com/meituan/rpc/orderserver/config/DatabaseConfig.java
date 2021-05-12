package jayfeng.com.meituan.rpc.orderserver.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * 多数据源配置
 * @author JayFeng
 * @date 2021/5/12
 */
@Configuration
public class DatabaseConfig {

    /**
     * 外卖订单数据源
     * @return 返回
     */
    @Bean
    @ConfigurationProperties("spring.datasource.takeaway-order")
    public DataSource takeawayOrderDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 优惠券、红包、津贴数据源
     * @return 返回
     */
    @Bean
    @ConfigurationProperties("spring.datasource.discount")
    public DataSource discountDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 获取SqlSessionFactory
     * @param dataSource 数据源
     * @return 返回
     * @throws Exception
     */
    public SqlSessionFactory getSqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        factoryBean.setConfiguration(configuration);
        return factoryBean.getObject();
    }

}
