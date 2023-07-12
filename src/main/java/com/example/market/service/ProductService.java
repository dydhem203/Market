package com.example.market.service;

import com.example.market.dto.Product;


public interface ProductService {
    Product getProductDataByProductCode(String productCode);
}
