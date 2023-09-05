package com.example.market.service;

import com.example.market.dto.Purchase;
import com.example.market.dto.Review;
import com.example.market.dto.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    int join(User user);
    List<Purchase> getPurchaseData(String userId);
    int addReview(Map<String, Object> param);
    Review getReviewDataByPurchaseNo(String purchaseNo, String userId);
}
