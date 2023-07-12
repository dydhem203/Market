package com.example.market.controller;

import com.example.market.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    /**
     * http://localhost:8080/product/detail?productCode=1000001654
     * @param request
     * @param response
     * @param paramgeters
     * @return
     */
    @GetMapping("/detail")
    public ModelAndView getProductDetailPage(HttpServletRequest request, HttpServletResponse response, @RequestParam Map<String, Object> paramgeters){
        ModelAndView mv = new ModelAndView("");
        mv.addObject("product", productService.getProductDataByProductCode(String.valueOf(paramgeters.get("productCode"))));
        return mv;
    }
}
