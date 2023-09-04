package com.example.market.service.impl;

import com.example.market.dto.Product;
import com.example.market.dto.Review;
import com.example.market.dto.SearchParam;
import com.example.market.mapper.ProductMapper;
import com.example.market.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

        if (searchParam.getSort() == null) {
            searchParam.setSort("productCode");
        } else if (searchParam.getSort().equals("priced")) {
            searchParam.setSort("price");
            searchParam.setOrderBy("desc");
        }
        return productMapper.getProducts(startIdx, searchParam);        // 추천순
    }


    @Override
    public List<Product> getPopularProducts() {
        return productMapper.getPopularProducts();
    }

    @Override
    public int getAllProductsCnt(String searchText) {
        if (searchText == null) {
            searchText = "";
        }
        System.out.println("getAllProductsCnt - Service()");
        System.out.println(searchText);
        return productMapper.getAllProductsCnt(searchText);
    }

    @Override
    public int addReview(Map<String, Object> param){
        return productMapper.addReview(param);
    }

    @Override
    public Review getReviewDataByProductCode(String productCode, String userId){
        Map<String, Object> param = Map.of("productCode", productCode, "userId", userId);
        return productMapper.getReviewDataByProductCode(param);
    }
}
