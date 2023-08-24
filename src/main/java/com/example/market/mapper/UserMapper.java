package com.example.market.mapper;

import com.example.market.dto.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int joinUser(User user);
    User findByUserid(String userId);
}
