package com.example.market.mapper;

import com.example.market.dto.Product;
import com.example.market.dto.ProductImage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    Product getProductDataByProductCode(String productCode);
    List<ProductImage> getProductImagesByProductCode(String productCode);
    List<Product> getProducts();

    List<Product> getPopularProducts();
}
