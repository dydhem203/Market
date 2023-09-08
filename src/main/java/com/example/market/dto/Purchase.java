package com.example.market.dto;

import lombok.Data;

@Data
public class Purchase {
    private String no;
    private String userId;
    private String productCode;
    private String productName;
    private String price;
    private String dcPrice;
    private String image;
    private String cnt;
    private String purchaseDate;
    private String state;
    private String stateName;

    public String getStateName(){
        String statusName = "";
        if("01".equals(this.state)) return "구매완료";
        else if("02".equals(this.state)) return "결제완료";
        else if("03".equals(this.state)) return "배송완료";
        else return "";
    }
}
