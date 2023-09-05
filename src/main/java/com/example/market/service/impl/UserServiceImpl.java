package com.example.market.service.impl;

import com.example.market.dto.Purchase;
import com.example.market.dto.Review;
import com.example.market.dto.User;
import com.example.market.mapper.UserMapper;
import com.example.market.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public int join(User user){
        User findUser = userMapper.findByUserid(user.getUserId());
        if(findUser != null){
            throw new IllegalStateException("이미 존재하는 아이디입니다.");
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPw(passwordEncoder.encode(user.getPw()));
        return userMapper.joinUser(user);
    }

    @Override
    public List<Purchase> getPurchaseData(String userId){
        return userMapper.getParchaseDataByUserId(userId);
    }

    @Override
    public Review getReviewDataByPurchaseNo(String purchaseNo, String userId){
        Map<String, Object> param = Map.of("purchaseNo", purchaseNo, "userId", userId);
        return userMapper.getReviewDataByPurchaseNo(param);
    }

    @Transactional
    @Override
    public int addReview(Map<String, Object> param){
        int addReviewCnt;
        if(ObjectUtils.isEmpty(param.get("no")))
            addReviewCnt = userMapper.addReview(param);
        else
            addReviewCnt = userMapper.updateReview(param);
        int updateProductCnt = userMapper.updateReviewToProduct(param);
        if(addReviewCnt > 0 && updateProductCnt > 0) return 1;
        else return 0;
    }
}
