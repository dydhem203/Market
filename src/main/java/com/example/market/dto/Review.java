package com.example.market.dto;

import lombok.Data;

@Data
public class Review {
    private String no;
    private String userId;
    private String purchaseNo;
    private String productCode;
    private String productName;
    private String price;
    private String dcPrice;
    private String image;
    private String contents;
    private String point;
    private String regDate;
    private String updDate;
}
