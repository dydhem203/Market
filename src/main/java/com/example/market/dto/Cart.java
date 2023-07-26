package com.example.market.dto;

import lombok.Data;

@Data
public class Cart {
    private int no;
    private String userId;
    private int cnt;
    private String cartDate;
    private String productCode;
    private String productName;
    private String dcPrice;
    private String image;
}
