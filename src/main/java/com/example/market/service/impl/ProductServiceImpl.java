package com.example.market.service.impl;

import com.example.market.dto.Product;
import com.example.market.mapper.ProductMapper;
import com.example.market.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;

    public Product getProductDataByProductCode(String productCode){
        Product product = productMapper.getProductDataByProductCode(productCode);
        product.setProductImageList(productMapper.getProductImagesByProductCode(productCode));
        return product;
    }

    @Override
    public List<Product> getProducts() {
        return productMapper.getProducts();
    }

    @Override
    public List<Product> getPopularProducts() {
        return productMapper.getPopularProducts();
    }
}
