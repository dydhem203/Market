package com.example.market.repositpry.impl;

import com.example.market.dto.Cart;
import com.example.market.dto.Product;
import com.example.market.dto.ProductImage;
import com.example.market.repositpry.ProductRepository;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private final EntityManager em;

    public ProductRepositoryImpl(EntityManager em) {
        this.em = em;
    }
    @Override
    public Product getProductDataByProductCode(String productCode){
        return em.find(Product.class, productCode);
    }

    @Override
    public List<Product> getProducts() {
        return em.createQuery("select p from Product p order by scope desc limit 8", Product.class).getResultList();
    }

}
