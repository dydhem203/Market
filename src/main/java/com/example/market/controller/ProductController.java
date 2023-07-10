package com.example.market.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {

    /**
     * http://localhost:8080/product/detail?productCode=1234
     * @param request
     * @param response
     * @param paramgeters
     * @return
     */
    @GetMapping("/detail")
    public JSONObject getProductDetailPage(HttpServletRequest request, HttpServletResponse response, @RequestParam Map<String, Object> paramgeters){
        return null;
    }
}
