package com.example.market.service;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Map;

public interface CartService {
    int addCart(HttpServletRequest request, Map<String, Object> paramgeters);
}
