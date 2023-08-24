package com.example.market.controller;

import com.example.market.service.CartService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Map;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService cartService;

    /**
     * http://localhost:8080/cart/main
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/main")
    public String viewCartPage(Principal principal, Model model){
        if(principal != null)
            model.addAttribute("carts", cartService.getCartDatasByUserId(principal.getName()));
        return "cart";
    }

    /**
     * 로그인 할 때, 로그인 한 상태에서 장바구니 클릭했을 때 호출
     * http://localhost:8080/cart/addCart
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/addCart")
    public String addCart(Principal principal, @RequestBody Map<String, Object> params) {
        int result = 0;
        if(principal != null)
            result = cartService.addCart(principal.getName(), params);
        return "redirect:/";
    }

    @PostMapping("/removeCart")
    public String removeCart(Principal principal, @RequestParam Map<String, Object> params, Model model) {
        if(principal != null){
            cartService.removeCart(principal.getName(), params);
            model.addAttribute("carts", cartService.getCartDatasByUserId(principal.getName()));
        }
        return "cart";
    }
}
