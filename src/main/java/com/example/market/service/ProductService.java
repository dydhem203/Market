package com.example.market.service;

import com.example.market.dto.Product;
import java.util.List;


public interface ProductService {
    Product getProductDataByProductCode(String productCode);

    List<Product> getProducts(int startIdx, int productsPerPage);

    List<Product> getPopularProducts();

    int getAllProductsCnt();
}
