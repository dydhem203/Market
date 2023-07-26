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
        // 사용자의 기존 장바구니 정보 조회
        List<Cart> carts1 = cartMapper.getCartDatasByUserId(userId);
        // 추가할 장바구니 정보
        List<Map<String, Object>> carts2 = (List<Map<String, Object>>) paramgeters.get(CommonConstatns.cartItems);
        for (Map<String, Object> cart2:carts2) {
            String productCode = String.valueOf(cart2.get(CommonConstatns.productCode));
            for (Cart cart1: carts1) {
                if(productCode.equals(cart1.getProductCode())){
                }
            }
        }
        // 장바구니 추가
        return cartMapper.addUserCartData(carts1);
    }
}
