package com.example.market.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Data
public class SearchParam {
    private String searchText;
    private String sort;
    private int currentPage = 1;
    private int pageSize = 12;
    private String orderBy;
}
