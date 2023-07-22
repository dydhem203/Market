package com.example.market.repositpry;

import com.example.market.dto.Product;

import java.util.List;

public interface ProductRepository {
    Product getProductDataByProductCode(String productCode);

    List<Product> getProducts();
}
