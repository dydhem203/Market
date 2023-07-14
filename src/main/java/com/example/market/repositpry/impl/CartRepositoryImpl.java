package com.example.market.repositpry.impl;

import com.example.market.dto.Cart;
import com.example.market.repositpry.CartRepository;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartRepositoryImpl implements CartRepository {
    private final EntityManager em;
    public CartRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    public List<Cart> getCartDataByUserId(String userId){
        return em.createQuery("select c from Cart c where c.userId = :userId", Cart.class).setParameter("userId", userId).getResultList();
    }
    public int addUserCartData(List<Cart> carts){
        return 0;
    }
}
