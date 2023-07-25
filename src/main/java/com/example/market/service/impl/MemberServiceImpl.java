package com.example.market.service.impl;

import com.example.market.dto.MemberDTO;
import com.example.market.entity.MemberEntity;
import com.example.market.repositpry.MemberRepository;
import com.example.market.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {


    public void join(MemberDTO memberDTO) {

        MemberEntity memberEntity = MemberEntity.toSaveEntity(memberDTO);
//        memberRepository.save(memberEntity);
    }
    
    public MemberDTO update(MemberDTO memberDTO) {
        
        MemberEntity memberEntity = MemberEntity.toUpdateEntity(memberDTO);
//        memberRepository.save(memberEntity);
        
        return findById(memberDTO.getNo());
    }

    private MemberDTO findById(int no) {

//        Optional<MemberEntity> optionalMemberEntity = memberRepository.findByNo(no);
//
//        if (optionalMemberEntity.isPresent()) {
//
//            MemberEntity memberEntity = optionalMemberEntity.get();
//            return MemberDTO.toMemberDTO(memberEntity);
//        } else {
//            return null;
//        }
        return null;
    }

}
