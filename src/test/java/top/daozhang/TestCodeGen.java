package top.daozhang;

import com.mybatisflex.codegen.Generator;
import com.mybatisflex.codegen.config.GlobalConfig;
import com.mybatisflex.codegen.dialect.JdbcTypeMapping;
import org.testng.annotations.Test;
import top.daozhang.util.FlexUtil;

import java.time.LocalDate;
import java.util.Date;

@Test
public class TestCodeGen {


    public void run() {
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.addGenerateTable("t_user", "t_order");// 需要生成的表
        var pac = "top.daozhang";
        globalConfig.setEntityPackage(pac+".entity");// 实体包
        globalConfig.setTablePrefix("t_");// 表的前缀风格
        globalConfig.setEntityWithLombok(true);// 是否使用lombok
        globalConfig.setMapperPackage(pac +".mapper");//mapper所在包
        globalConfig.setMapperGenerateEnable(true);// 如果开启了 ，  apt记得关闭
        globalConfig.setMapperOverwriteEnable(false);// 不允许覆盖
        globalConfig.setServicePackage(pac+".service");
        globalConfig.setServiceImplPackage(pac+".service.impl");
        globalConfig.setServiceGenerateEnable(true); // service生成
        globalConfig.setServiceImplGenerateEnable(true); // service实现类生成
        JdbcTypeMapping.registerMapping(LocalDate.class, Date.class); // 将Date替换为LocalDate，
        Generator generator = new Generator(FlexUtil.getIns().getDataSource(), globalConfig);
        generator.generate();

    }

}
