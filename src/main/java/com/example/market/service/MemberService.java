package com.example.market.service;

import com.example.market.dto.MemberDTO;
import com.example.market.entity.MemberEntity;

public interface MemberService {
    void join(MemberDTO memberDTO);
}
