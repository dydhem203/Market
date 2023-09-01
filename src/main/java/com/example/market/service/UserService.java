package com.example.market.service;

import com.example.market.dto.Purchase;
import com.example.market.dto.User;

import java.util.List;

public interface UserService {
    int join(User user);
    List<Purchase> getPurchaseData(String userId);
}
