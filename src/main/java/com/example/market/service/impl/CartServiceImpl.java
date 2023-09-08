package com.example.market.service.impl;

import com.example.market.constatnts.CommonConstatns;
import com.example.market.dto.Cart;
import com.example.market.dto.Purchase;
import com.example.market.mapper.CartMapper;
import com.example.market.service.CartService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartMapper cartMapper;

    @Override
    public List<Cart> getCartDatasByUserId(String userId){
        return cartMapper.getCartDatasByUserId(userId);
    }

    @Override
    public List<Cart> getCartDatasByProductCode(Map<String, Object> params){
        try {
            JsonArray array = (JsonArray) new JsonParser().parse(String.valueOf(params.get("cartItems")));
            List<Map<String, Object>> cartDatas = new ArrayList<>();

            Gson gson = new Gson();
            for (Object jsonObject : array) {
                cartDatas.add(gson.fromJson(jsonObject.toString(), Map.class));
            }
            return cartMapper.getCartDatasByProductCode(cartDatas);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int addCart(String userId, Map<String, Object> paramgeters){
        List<Map<String, Object>> carts = (List<Map<String, Object>>) paramgeters.get(CommonConstatns.cartItems);
        // 장바구니 추가
        return cartMapper.addUserCartData(carts, userId);
    }

    @Override
    public int removeCart(String userId, Map<String, Object> paramgeters){
        String productCode = String.valueOf(paramgeters.get(CommonConstatns.productCode));
        // 장바구니 추가
        return cartMapper.removeUserCartData(productCode, userId);
    }

    @Override
    public int addPurchaseItems(String userId, List<Purchase> purchases) {
        // 구매 테이블에 해당 내용 적재
        return cartMapper.addPurchaseItems(userId, purchases);
    }

    @Override
    public List<Purchase> getPurchaseItemsByUserId(String userId) {
        return cartMapper.getPurchaseItemsByUserId(userId);
    }

    @Override
    public int removeCartItems(String userId, List<Purchase> purchases) {
        return cartMapper.removeCartItems(userId, purchases);
    }
}
