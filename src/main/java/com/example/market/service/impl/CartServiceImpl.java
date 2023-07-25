package com.example.market.service.impl;

import com.example.market.dto.Cart;
import com.example.market.mapper.CartMapper;
import com.example.market.service.CartService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CartServiceImpl implements CartService {
//    @Autowired
//    CartMapper cartMapper;

    @Override
    public List<Cart> getCartDatasByUserId(String userId){

        return null;
    }

    @Override
    public int addCart(HttpServletRequest request, Map<String, Object> paramgeters){
        String userId = "jyjang";
//        // 사용자의 기존 장바구니 정보 조회
//        List<Cart> carts = cartRepository.getCartDatasByUserId(userId);
//        // 추가할 장바구니 정보
//        List<Map<String, Object>> cartItems = (List<Map<String, Object>>) paramgeters.get(CommonConstatns.cartItems);
//        // 기존 장바구니 + 추가할 장바구니
//        List<Cart> newCartData = new ArrayList<>();
//
//        // 장바구니 추가
//        return cartRepository.addUserCartData(newCartData);
        return 0;
    }
}
