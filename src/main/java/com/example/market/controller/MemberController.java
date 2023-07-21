package com.example.market.controller;

import com.example.market.dto.MemberDTO;
import com.example.market.entity.MemberEntity;
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

    private final MemberService memberService;

    @GetMapping("/login")
    public String loginForm() {

        return "/member/loginForm";
    }

    @GetMapping("/join")
    public String signupForm() {
        return "/member/joinForm";
    }

    @PostMapping("/join")
    public String joinSignUpForm(@ModelAttribute MemberDTO memberDTO) throws IOException {

        memberService.join(memberDTO);
        return "home";
    }


}
