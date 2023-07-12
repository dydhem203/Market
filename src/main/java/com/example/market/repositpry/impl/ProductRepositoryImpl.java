package com.example.market.repositpry.impl;

import com.example.market.dto.Product;
import com.example.market.repositpry.ProductRepository;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private final EntityManager em;

    public ProductRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    public Product getProductDataByProductCode(String productCode){
        return em.find(Product.class, productCode);
    }
}
