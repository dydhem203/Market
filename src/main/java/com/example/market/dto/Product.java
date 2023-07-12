package com.example.market.dto;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Product {
    @Id
    private String productCode;
    private String productName;
    private String price;
    private String dcPrice;
    private String image;
    private String cnt;
    private String inStock;
    private String dcRate;
    private String brand;
    private String deliveryType;
}
