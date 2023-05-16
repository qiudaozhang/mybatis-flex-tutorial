package top.daozhang;

import com.alibaba.druid.pool.DruidDataSource;
import com.jfinal.template.Engine;
import com.mybatisflex.codegen.Generator;
import com.mybatisflex.codegen.config.ColumnConfig;
import com.mybatisflex.codegen.config.GlobalConfig;
import com.mybatisflex.codegen.config.TableConfig;
import com.mybatisflex.codegen.dialect.JdbcTypeMapping;
import com.mybatisflex.core.MybatisFlexBootstrap;
import org.apache.ibatis.type.JdbcType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import top.daozhang.mapper.UserMapper;

import java.time.LocalDate;
import java.util.Date;

@Test
public class TestCodeGen {

    MybatisFlexBootstrap ins;

    @BeforeClass
    public void init() {

        DruidDataSource dataSource = new DruidDataSource();

        dataSource.setUrl("jdbc:mysql://localhost:3306/mf_db");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        ins = MybatisFlexBootstrap.getInstance();
        ins.setDataSource(dataSource)
                .addMapper(UserMapper.class)
                .start();
    }


    public void run(){

        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.addGenerateTable("t_user","t_order");// 需要生成的表
        globalConfig.setEntityPackage("top.daozhang.entity");// 实体包
        globalConfig.setTablePrefix("t_");// 表的前缀风格
        globalConfig.setEntityWithLombok(true);// 是否使用lombok
        globalConfig.setMapperPackage("top.daozhang.mapper");//mapper所在包
        globalConfig.setMapperGenerateEnable(true);// 如果开启了 ，  apt记得关闭
        globalConfig.setMapperOverwriteEnable(false);// 不允许覆盖
        JdbcTypeMapping.registerMapping(LocalDate.class, Date.class); // 将Date替换为LocalDate，
        Generator generator = new Generator(ins.getDataSource(),globalConfig);
        generator.generate();

    }

}
