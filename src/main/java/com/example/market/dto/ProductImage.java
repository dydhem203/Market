package com.example.market.dto;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ProductImage {
    @Id
    private String no;
    @Column(name = "productCode")
    private String productCode;
    private String image;
    private String imgOrder;

//    @ManyToOne
//    @JoinColumn(name = "productCode")
//    private Product product;
//
//    //무한 루프에 빠지지 않도록 체크
//    public void setProduct(Product product){
//        this.product = product;
//        if(!product.getProductImages().contains(this)){
//            product.getProductImages().add(this);
//        }
//    }
}
