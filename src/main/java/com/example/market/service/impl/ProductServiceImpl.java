package com.example.market.service.impl;

import com.example.market.dto.Product;
import com.example.market.dto.SearchParam;
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
    public List<Product> getProducts(int startIdx, SearchParam searchParam) {
        return productMapper.getProducts(startIdx, searchParam);        // 추천순
    }


    @Override
    public List<Product> getPopularProducts() {
        return productMapper.getPopularProducts();
    }

    @Override
    public int getAllProductsCnt() {
        return productMapper.getAllProductsCnt();
    }
}
