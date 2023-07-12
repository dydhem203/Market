package com.example.market.service.impl;

import com.example.market.dto.Product;
import com.example.market.repositpry.ProductRepository;
import com.example.market.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    public Product getProductDataByProductCode(String productCode){
        return productRepository.getProductDataByProductCode(productCode);
    }
}
