package com.example.market.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Cart {
    @Id
    private int no;
    private String userId;
    private String productCode;
    private int cnt;
    private String cartDate;
}
