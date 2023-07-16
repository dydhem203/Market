package com.example.market.controller;

import com.example.market.dto.Member;
import com.example.market.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    public final MemberService memberService;

    @GetMapping("/login")
    public String loginForm() {

        return "/member/loginForm";
    }

    @GetMapping("/signup")
    public String signupForm() {
        return "/member/signupForm";
    }

    @PostMapping("/signup")
    public String saveSignUpForm(@ModelAttribute Member memberDTO) throws IOException {

        memberService.save(memberDTO);

        return "/home";
    }


}
