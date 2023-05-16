package top.daozhang;

import com.alibaba.druid.pool.DruidDataSource;
import com.mybatisflex.core.MybatisFlexBootstrap;
import com.mybatisflex.core.query.QueryCondition;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.row.Db;
import com.mybatisflex.core.row.Row;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import top.daozhang.entity.User;
import top.daozhang.mapper.UserMapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static top.daozhang.entity.table.Tables.USER;

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


//    @Test
//    public void insert() {
//        UserMapper mapper = ins.getMapper(UserMapper.class);
//        User u = User.builder().nickname("迪丽热巴").birthday(LocalDate.of(1990, 1, 1))
//                .created(LocalDateTime.now())
//                .sex(0)
//                .build();
//
//        log.info("save user");
//        mapper.insert(u);
//    }

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
        //  直接使用query column的方式写入nickname并不能利用静态类型的特点
        // 使用APT 生产，字段名自动维护
        QueryCondition qc = USER.NICKNAME.eq("迪丽热巴");
        q.and(qc);
        User user = mapper.selectOneByQuery(q);
        log.info(user.toString());
    }

//    @Test
//    public void updateOne() {
//        UserMapper mapper = ins.getMapper(UserMapper.class);
//        var q = new QueryWrapper();
//        q.and(USER.NICKNAME.eq("迪丽热巴"));
//        User user = mapper.selectOneByQuery(q);
//        user.setBirthday(LocalDate.of(1998,12,3));
//        mapper.update(user);
//    }

    @Test
    public void deleteOne() {
        UserMapper mapper = ins.getMapper(UserMapper.class);
        mapper.deleteByCondition(USER.NICKNAME.eq("迪丽热巴"));
    }




    public void dbRow(){
        String sql = "select * from t_user where id > ?";
        List<Row> rows = Db.selectListBySql(sql, 1);
        rows.forEach(a->log.info(a.toString()));
    }
}
