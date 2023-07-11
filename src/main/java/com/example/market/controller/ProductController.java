package com.example.market.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController {

    /**
     * http://localhost:8080/product/detail?productCode=1234
     * 상품 상세 페이지
     * @param request
     * @param response
     * @param paramgeters
     * @return
     */
    @GetMapping("/detail")
    public ModelAndView getProductDetailPage(HttpServletRequest request, HttpServletResponse response, @RequestParam Map<String, Object> paramgeters){
        ModelAndView mv = new ModelAndView("");



        return mv;
    }
}
