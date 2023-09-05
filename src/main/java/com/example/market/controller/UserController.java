package com.example.market.controller;

import com.example.market.dto.User;
import com.example.market.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/loginPage")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/joinPage")
    public String joinPage() {
        return "join";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute User user, Model model) {
        try {
            userService.join(user);
            return "login";
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "join";
        }
    }


    @GetMapping(value = "/error")
    public String loginError(Model model) {
        model.addAttribute("errorMessage", "아이디 또는 비밀번호를 확인해주세요.");
        return "login";
    }

    @GetMapping("/logout")   // http://localhost:8080/user/logout
    public String logout() {
        return "login";
    }

    @GetMapping("/purchasePage")
    public String getPurchaseData(Principal principal, Model model){
        if(principal != null)
            model.addAttribute("purchases", userService.getPurchaseData(principal.getName()));
        return "purchase";
    }

    @GetMapping("/review/{purchaseNo}")
    public String reviewPage(@PathVariable("purchaseNo") String purchaseNo, Principal principal, Model model){
        model.addAttribute("review",userService.getReviewDataByPurchaseNo(purchaseNo, principal.getName()));
        return "review";
    }

    @PostMapping("/addReview")
    public String addReview(Principal principal, @RequestParam Map<String, Object> param){
        param.put("userId", principal.getName());
        userService.addReview(param);
        return "review";
    }
}
