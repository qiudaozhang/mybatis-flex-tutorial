package top.daozhang.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import top.daozhang.entity.User;
import top.daozhang.mapper.UserMapper;
import top.daozhang.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}