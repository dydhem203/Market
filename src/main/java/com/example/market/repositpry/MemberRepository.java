package com.example.market.repositpry;

import com.example.market.entity.MemberEntity;

import java.util.Optional;

public interface MemberRepository {

    boolean existsByUserId(String userId);

    boolean existsByEmail(String email);

    Optional<MemberEntity> findByNo(int no);
}
