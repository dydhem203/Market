package com.example.market.controller;

import com.example.market.dto.Purchase;
import com.example.market.service.CartService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService cartService;

    /**
     * http://localhost:8080/cart/main
     *
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/main")
    public String viewCartPage(Principal principal, Model model, @RequestParam Map<String, Object> params) {
        if (principal == null) {
            if (params.get("cartItems") != null && !"null".equals(params.get("cartItems")))
                model.addAttribute("carts", cartService.getCartDatasByProductCode(params));
        } else
            model.addAttribute("carts", cartService.getCartDatasByUserId(principal.getName()));
        return "cart";
    }

    /**
     * 로그인 할 때, 로그인 한 상태에서 장바구니 클릭했을 때 호출
     * http://localhost:8080/cart/addCart
     *
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/addCart")
    public String addCart(Principal principal, @RequestBody Map<String, Object> params) {
        int result = 0;
        if (principal != null)
            result = cartService.addCart(principal.getName(), params);
        return "redirect:/";
    }

    @PostMapping("/removeCart")
    public String removeCart(Principal principal, @RequestParam Map<String, Object> params, Model model) {
        if (principal != null) {
            cartService.removeCart(principal.getName(), params);
            model.addAttribute("carts", cartService.getCartDatasByUserId(principal.getName()));
        }
        return "cart";
    }

    @PostMapping("/purchase")
    public String purchaseItems(Principal principal, @RequestParam Map<String, Object> params, Model model) throws JsonProcessingException {
        if (principal != null) {
            String json = params.get("buyItems").toString();
            ObjectMapper mapper = new ObjectMapper();
            List list = mapper.readValue(json, new TypeReference<List<Purchase>>(){});
            // 구매 테이블에 추가
            cartService.addPurchaseItems(principal.getName(), list);
            // 장바구니 테이블에서 삭제
            //cartService.removeCartItems(principal.getName(), purchases);
            // 구매 테이블에 있는 데이터 보내기
            model.addAttribute("purchases", cartService.getPurchaseItemsByUserId(principal.getName()));
        }
        return "purchase";
    }
}
