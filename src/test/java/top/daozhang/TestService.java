package top.daozhang;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryCondition;
import com.mybatisflex.core.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;
import top.daozhang.config.BeanConfig;
import top.daozhang.entity.Order;
import top.daozhang.entity.User;
import top.daozhang.mapper.OrderMapper;
import top.daozhang.service.UserService;
import top.daozhang.service.impl.UserServiceImpl;
import top.daozhang.util.FlexUtil;

import java.util.List;

import static top.daozhang.entity.table.Tables.USER;

@Test
@Slf4j
public class TestService {

    public void joinQuery() {
        // 需要build project
//        OrderMapper mapper = FlexUtil.getMapper(OrderMapper.class);
        // service要配合spring使用
        var app = new AnnotationConfigApplicationContext(BeanConfig.class);
        app.start();
        UserService userService = app.getBean(UserService.class);
        var q =new QueryWrapper();
        q.where(USER.NICKNAME.in("迪丽热巴"));
//        List<User> list = userService.list(q);
//        list.forEach(a->log.info(a.toString()));
        List<User> users = userService.getMapper().selectListByQuery(q);
        users.forEach(a->log.info(a.toString()));

//        userService.list().forEach(a->log.info(a.toString()));

    }


}
