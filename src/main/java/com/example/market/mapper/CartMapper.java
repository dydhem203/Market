package com.example.market.mapper;

import com.example.market.dto.Cart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper {
    List<Cart> getCartDatasByUserId(String userId);
    int addUserCartData(List<Cart> carts);
}
