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
 * 优惠券、红包、津贴数据源
 * @author JayFeng
 * @date 2021/5/12
 */
@Configuration
@MapperScan(basePackages = {"jayfeng.com.meituan.rpc.dao.discount"}, sqlSessionFactoryRef = "discountSqlSessionFactory")
public class DiscountDBConfig {

    @Autowired
    private DatabaseConfig databaseConfig;

    @Autowired
    @Qualifier("discountDataSource")
    private DataSource discountDataSource;

    @Bean(name = "discountSqlSessionFactory")
    public SqlSessionFactory discountSqlSessionFactory() throws Exception {
        return databaseConfig.getSqlSessionFactory(discountDataSource);
    }

    @Bean(name = "discountSqlSessionTemplate")
    public SqlSessionTemplate discountSqlSessionTemplate(@Qualifier("discountSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
