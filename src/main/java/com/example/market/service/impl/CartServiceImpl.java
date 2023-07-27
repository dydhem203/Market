package com.example.market.service.impl;

import com.example.market.constatnts.CommonConstatns;
import com.example.market.dto.Cart;
import com.example.market.mapper.CartMapper;
import com.example.market.service.CartService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartMapper cartMapper;

    @Override
    public List<Cart> getCartDatasByUserId(String userId){
        return cartMapper.getCartDatasByUserId(userId);
    }

    @Override
    public int addCart(HttpServletRequest request, Map<String, Object> paramgeters){
        String userId = "jyjang";
        List<Map<String, Object>> carts = (List<Map<String, Object>>) paramgeters.get(CommonConstatns.cartItems);
        // 장바구니 추가
        return cartMapper.addUserCartData(carts, userId);
    }

    @Override
    public int removeCart(HttpServletRequest request, Map<String, Object> paramgeters){
        String userId = "jyjang";
        String productCode = String.valueOf(paramgeters.get(CommonConstatns.productCode));
        // 장바구니 추가
        return cartMapper.removeUserCartData(productCode, userId);
    }
}
