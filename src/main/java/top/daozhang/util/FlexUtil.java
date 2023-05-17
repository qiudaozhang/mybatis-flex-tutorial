package top.daozhang.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.mybatisflex.core.MybatisFlexBootstrap;
import top.daozhang.mapper.OrderMapper;
import top.daozhang.mapper.UserMapper;

public class FlexUtil {

    private static MybatisFlexBootstrap ins;


    static {
        DruidDataSource dataSource = new DruidDataSource();

        dataSource.setUrl("jdbc:mysql://localhost:3306/mf_db");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        ins = MybatisFlexBootstrap.getInstance();
        ins.setDataSource(dataSource)
                .addMapper(UserMapper.class)
                .addMapper(OrderMapper.class)
                .start();
    }


    public static MybatisFlexBootstrap getIns() {
        return ins;
    }

    public static <T> T getMapper(Class<T> c){
        return ins.getMapper(c);
    }
}
