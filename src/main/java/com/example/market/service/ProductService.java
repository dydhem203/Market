package com.example.market.service;

import com.example.market.dto.Product;
import com.example.market.dto.SearchParam;
import org.springframework.core.annotation.MergedAnnotations;

import java.util.List;


public interface ProductService {
    Product getProductDataByProductCode(String productCode);

    List<Product> getProducts(int startIdx, SearchParam searchParam);

    List<Product> getPopularProducts();

    int getAllProductsCnt(String searchText);
}
