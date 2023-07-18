package com.example.market.service;

import com.example.market.dto.Cart;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.Map;

public interface CartService {
    List<Cart> getCartDatasByUserId(String userId);
    int addCart(HttpServletRequest request, Map<String, Object> paramgeters);
}
