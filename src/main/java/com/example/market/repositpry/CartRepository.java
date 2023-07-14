package com.example.market.repositpry;

import com.example.market.dto.Cart;

import java.util.List;

public interface CartRepository {
    List<Cart> getCartDataByUserId(String userId);
    int addUserCartData(List<Cart> carts);
}
