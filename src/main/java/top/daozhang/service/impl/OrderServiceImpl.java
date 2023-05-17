package top.daozhang.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import top.daozhang.entity.Order;
import top.daozhang.mapper.OrderMapper;
import top.daozhang.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}