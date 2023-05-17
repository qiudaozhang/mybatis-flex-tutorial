package top.daozhang;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import top.daozhang.dto.UserDto;
import top.daozhang.entity.Order;
import top.daozhang.mapper.OrderMapper;
import top.daozhang.mapper.UserMapper;
import top.daozhang.util.FlexUtil;

import java.util.List;

import static top.daozhang.entity.table.Tables.ORDER;
import static top.daozhang.entity.table.Tables.USER;

@Test
@Slf4j
public class TestPage {

    public void joinQuery() {
        // 需要build project
        OrderMapper mapper = FlexUtil.getMapper(OrderMapper.class);
        QueryWrapper q = QueryWrapper.create();

        Page<Order> page = mapper.paginate(1, 1, q);
        log.info("total {}, size {}, pageNumber {}, total pages{}",page.getTotalPage(),page.getPageSize(),page.getPageNumber(),page.getTotalPage());
        List<Order> records = page.getRecords();
        records.forEach(r->log.info(r.toString()));

    }


}
