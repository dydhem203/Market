package com.example.market.dto;

import lombok.Data;

import java.util.List;

@Data
public class Product {
    private String productCode;
    private String productName;
    private String price;
    private String dcPrice;
    private String image;
    private String regCnt;
    private String remCnt;
    private String dcRate;
    private String brand;
    private String sellerId;
    private String unit;
    private String amt;
    private String origin;
    private String allergy;
    private String expDate;
    private String details;
    private int scope;
    private List<ProductImage> productImageList;
}
