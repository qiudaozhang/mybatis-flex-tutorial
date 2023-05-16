package top.daozhang;

import com.alibaba.druid.pool.DruidDataSource;
import com.mybatisflex.core.MybatisFlexBootstrap;
import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.query.QueryCondition;
import com.mybatisflex.core.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import top.daozhang.entity.User;
import top.daozhang.mapper.UserMapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Test
@Slf4j
public class TestSimpleCrud {

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


    @Test
    public void insert() {
        UserMapper mapper = ins.getMapper(UserMapper.class);
        User u = User.builder().nickname("迪丽热巴").birthday(LocalDate.of(1990, 1, 1))
                .created(LocalDateTime.now())
                .sex(0)
                .build();

        log.info("save user");
        mapper.insert(u);
    }

    @Test
    public void selectAll() {
        UserMapper mapper = ins.getMapper(UserMapper.class);
        List<User> users = mapper.selectAll();
        users.forEach(a -> {
                    log.info(a.toString());
                }
        );
    }
    @Test
    public void findOne() {
        UserMapper mapper = ins.getMapper(UserMapper.class);
        var q = new QueryWrapper();
        q.and(QueryCondition.create(new QueryColumn("nickname"),QueryCondition.LOGIC_EQUALS,"迪丽热巴"));
        User user = mapper.selectOneByQuery(q);
        log.info(user.toString());
    }

    @Test
    public void updateOne() {
        UserMapper mapper = ins.getMapper(UserMapper.class);
        var q = new QueryWrapper();
        q.and(QueryCondition.create(new QueryColumn("nickname"),QueryCondition.LOGIC_EQUALS,"迪丽热巴"));
        User user = mapper.selectOneByQuery(q);
        user.setBirthday(LocalDate.of(1998,12,3));
        mapper.update(user);
    }

    @Test
    public void deleteOne() {
        UserMapper mapper = ins.getMapper(UserMapper.class);
        QueryCondition queryCondition = QueryCondition.create(new QueryColumn("nickname"), QueryCondition.LOGIC_EQUALS, "迪丽热巴");
        mapper.deleteByCondition(queryCondition);
    }



}
