package top.daozhang;

import com.mybatisflex.core.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.Test;
import top.daozhang.config.BeanConfig;
import top.daozhang.entity.User;
import top.daozhang.mapper.UserMapper;
import top.daozhang.service.UserService;
import top.daozhang.util.FlexUtil;

import java.util.List;

import static top.daozhang.entity.table.Tables.USER;

@Test
@Slf4j
public class TestMapper {

    public void joinQuery() {
        // 需要build project
        UserMapper mapper = FlexUtil.getMapper(UserMapper.class);
        // service要配合spring使用
        var q =new QueryWrapper();
        q.where(USER.NICKNAME.in("迪丽热巴"));
        List<User> users =  mapper.selectListByQuery(q);
        users.forEach(a->log.info(a.toString()));


    }


}
