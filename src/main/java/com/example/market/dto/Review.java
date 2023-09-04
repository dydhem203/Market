package com.example.market.dto;

import lombok.Data;

@Data
public class Review {
    private String no;
    private String userId;
    private String productCode;
    private String contents;
    private String point;
    private String regDate;
    private String updDate;
}
