package com.example.market.service.impl;

import com.example.market.dto.User;
import com.example.market.mapper.UserMapper;
import com.example.market.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public int join(User user){
        User findUser = userMapper.findByUserid(user.getUserId());
        if(findUser != null){
            throw new IllegalStateException("이미 존재하는 아이디입니다.");
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPw(passwordEncoder.encode(user.getPw()));
        return userMapper.joinUser(user);
    }
}
