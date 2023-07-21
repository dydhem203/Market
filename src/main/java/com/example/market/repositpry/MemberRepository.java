package com.example.market.repositpry;

import com.example.market.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {

    boolean existsByUserId(String userId);

    boolean existsByEmail(String email);

    Optional<MemberEntity> findByNo(int no);
}
