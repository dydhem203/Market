package com.example.market.repositpry;

import com.example.market.dto.Product;

public interface ProductRepository {
    Product getProductDataByProductCode(String productCode);
}
