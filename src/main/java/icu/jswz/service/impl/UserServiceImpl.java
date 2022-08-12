package icu.jswz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import icu.jswz.mapper.UserMapper;
import icu.jswz.pojo.User;
import icu.jswz.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
}
