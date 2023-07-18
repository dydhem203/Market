package com.example.market.dto;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Cart {
    @Id
    private int no;
    private String userId;
    private int cnt;
    private String cartDate;

    @ManyToOne
    @JoinColumn(name = "productCode")
    Product product;
}
