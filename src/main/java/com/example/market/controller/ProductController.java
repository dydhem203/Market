package com.example.market.controller;

import com.example.market.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    /**
     * http://localhost:8080/product/detail/1000001654
     * @param model
     * @param productCode
     * @return
     */
    @GetMapping("/detail/{productCode}")
    public String getProductDetailPage(Model model, @PathVariable ("productCode") String productCode){
        model.addAttribute("product", productService.getProductDataByProductCode(productCode));
        return "productDetail";
    }
}
