package com.example.market.mapper;

import com.example.market.dto.Purchase;
import com.example.market.dto.Review;
import com.example.market.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    int joinUser(User user);
    User findByUserid(String userId);
    List<Purchase> getParchaseDataByUserId(String userId);
    Review getReviewDataByPurchaseNo(Map<String, Object> param);
    int addReview(Map<String, Object> param);
    int updateReview(Map<String, Object> param);
    int updateReviewToProduct(Map<String, Object> param);
}
