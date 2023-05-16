package top.daozhang;

import com.alibaba.druid.pool.DruidDataSource;
import com.mybatisflex.core.MybatisFlexBootstrap;
import top.daozhang.mapper.UserMapper;

public class SimpleCrud {


    public static void main(String[] args) {

        DruidDataSource dataSource  = new DruidDataSource();

        dataSource.setUrl("jdbc:mysql:://localhost:3306/mf_db");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        var ins = MybatisFlexBootstrap.getInstance();
        ins
                .setDataSource(dataSource)
                .addMapper(UserMapper.class)
                .start();

        UserMapper mapper = ins.getMapper(UserMapper.class);

    }
}
