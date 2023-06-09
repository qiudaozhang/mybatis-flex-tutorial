package top.daozhang;

import com.mybatisflex.core.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import top.daozhang.dto.UserDto;
import top.daozhang.mapper.UserMapper;
import top.daozhang.util.FlexUtil;

import java.util.List;

import static top.daozhang.entity.table.Tables.ORDER;
import static top.daozhang.entity.table.Tables.USER;

@Test
@Slf4j
public class TestJoin {

    public void joinQuery() {
        // 需要build project
        QueryWrapper q = QueryWrapper.create();
        q.select(USER.NICKNAME)
                .select(ORDER.UID, ORDER.GOODS_NAME, ORDER.AMOUNT, ORDER.ID)
                .leftJoin(ORDER).on(USER.ID.eq(ORDER.UID))
                .where(USER.NICKNAME.eq("迪丽热巴"));
        UserMapper mapper = FlexUtil.getMapper(UserMapper.class);
        // 1.2.4+才支持
        List<UserDto> userDtos = mapper.selectListByQueryAs(q, UserDto.class);
        userDtos.forEach(a -> log.info(a.toString()));
    }


}
