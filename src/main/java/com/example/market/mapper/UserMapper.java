package com.example.market.mapper;

import com.example.market.dto.Purchase;
import com.example.market.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int joinUser(User user);
    User findByUserid(String userId);
    List<Purchase> getParchaseDataByUserId(String userId);
}
