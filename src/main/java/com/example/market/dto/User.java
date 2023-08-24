package com.example.market.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int no;
    private String userId;
    private String pw;
    private String name;
    private String email;
    private String gender;
    private String hp;
    private String addr1;
    private String addr2;
    private String birthday;
    private String role;
}
