package top.daozhang;

import com.alibaba.druid.pool.DruidDataSource;
import com.mybatisflex.core.MybatisFlexBootstrap;
import com.mybatisflex.core.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import top.daozhang.dto.UserDto;
import top.daozhang.mapper.UserMapper;

import java.util.List;

import static top.daozhang.entity.table.Tables.ORDER;
import static top.daozhang.entity.table.Tables.USER;

@Test
@Slf4j
public class TestJoin {

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



    public void joinQuery(){
        // 需要build project
        QueryWrapper q  = QueryWrapper.create();
        q.select(USER.NICKNAME)
                .select(ORDER.UID,ORDER.GOODS_NAME,ORDER.AMOUNT,ORDER.ID)
                .leftJoin(ORDER).on(USER.ID.eq(ORDER.UID))
                .where(USER.NICKNAME.eq("迪丽热巴"));
        UserMapper mapper = ins.getMapper(UserMapper.class);
        // 1.2.4+才支持
        List<UserDto> userDtos = mapper.selectListByQueryAs(q, UserDto.class);
        userDtos.forEach(a->log.info(a.toString()));
    }


}
