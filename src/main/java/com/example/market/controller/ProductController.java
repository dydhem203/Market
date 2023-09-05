package com.example.market.controller;

import com.example.market.dto.SearchParam;
import com.example.market.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Map;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String getMainPage(Model model) {

        model.addAttribute("page", 1);
        model.addAttribute("popularProducts", productService.getPopularProducts());

        return "home";
    }


    /**
     * http://localhost:8080/product/detail/1
     *
     * @param model
     * @param productCode
     * @return
     */
    @GetMapping("/product/detail/{productCode}")
    public String getProductDetailPage(Model model, @PathVariable("productCode") String productCode) {
        model.addAttribute("product", productService.getProductDataByProductCode(productCode));
        return "product_details";
    }

    @PostMapping("/product")
    public String getProducts(Model model, @ModelAttribute SearchParam searchParam) {

        int totalProducts = productService.getAllProductsCnt(searchParam.getSearchText());    // 총 상품 개수ㄴ
        int totalPages = ((totalProducts-1) / searchParam.getPageSize()) + 1;             // 총 페이지 개수
        int displayPageNum = 10;         // 한 번에 표시할 페이지의 개수
        int startPage = ((searchParam.getCurrentPage()-1) / displayPageNum) * displayPageNum + 1;              // 시작 페이지 번호
        boolean prevTF = startPage != 1;         // 이전으로 가는 화살표 표시 여부
        int endPage = (((searchParam.getCurrentPage()-1)/displayPageNum)+1) * displayPageNum;                // 끝 페이지 번호
        if (totalPages < endPage) endPage = totalPages;
        boolean nextTF = endPage != totalPages;         // 다음으로 가는 화살표 표시 여부
        int startIdx = ((searchParam.getCurrentPage()-1) * searchParam.getPageSize())+1;

        model.addAttribute("products", productService.getProducts(startIdx, searchParam));
        model.addAttribute("searchParam", searchParam);
        model.addAttribute("prevTF", prevTF);
        model.addAttribute("startPage", startPage);
        model.addAttribute("currentPage", searchParam.getCurrentPage());
        model.addAttribute("endPage", endPage);
        model.addAttribute("nextTF", nextTF);

        return "products";
    }
}
