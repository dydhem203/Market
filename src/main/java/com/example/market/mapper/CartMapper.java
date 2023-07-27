package com.example.market.mapper;

import com.example.market.dto.Cart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CartMapper {
    List<Cart> getCartDatasByUserId(String userId);
    int addUserCartData(List<Map<String, Object>> carts, String userId);
    int removeUserCartData(String productCode, String userId);
}
