package top.daozhang.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import top.daozhang.mapper.UserMapper;
import top.daozhang.util.FlexUtil;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages ="top.daozhang")
@MapperScan(basePackages = {"top.daozhang.mapper"})
public class BeanConfig {


    @Bean
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/mf_db");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(   ){
        var config = new org.apache.ibatis.session.Configuration();
        TransactionFactory tx = new JdbcTransactionFactory();
        Properties properties = new Properties();
        properties.setProperty("url","jdbc:mysql://localhost:3306/mf_db");
        properties.setProperty("driver","com.mysql.cj.jdbc.Driver");
        properties.setProperty("username","root");
        properties.setProperty("password","root");
        tx.setProperties(properties);
        var env = new Environment("dev",tx,dataSource());
        config.setEnvironment(env);
        return new SqlSessionFactoryBuilder().build(config);
    }
}
