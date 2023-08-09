package com.example.market.service.impl;

import com.example.market.dto.User;
import com.example.market.mapper.UserMapper;
import com.example.market.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public int join(User user){
        return userMapper.joinUser(user);
    }
}
