package com.example.market.service;

import com.example.market.dto.Cart;
import com.example.market.dto.Purchase;

import java.util.List;
import java.util.Map;

public interface CartService {
    List<Cart> getCartDatasByUserId(String userId);
    List<Cart> getCartDatasByProductCode(Map<String, Object> params);
    int addCart(String userId, Map<String, Object> paramgeters);
    int removeCart(String userId, Map<String, Object> paramgeters);

    int addPurchaseItems(String userId, List<Purchase> purchases);

    List<Purchase> getPurchaseItemsByUserId(String userId);

    int removeCartItems(String userId, List<Purchase> purchases);
}
