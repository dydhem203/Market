package com.example.market.controller;

import com.example.market.dto.User;
import com.example.market.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/loginPage")   // http://localhost:8080/user/loginPage
    public String loginPage() {
        return "login";
    }

    @GetMapping("/joinPage")    // http://localhost:8080/user/joinPage
    public String joinPage() {
        return "join";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute User user) throws IOException {
        int result = userService.join(user);
        if(result<0){
            return "join";
        }else{
            return "login";
        }
    }
}
