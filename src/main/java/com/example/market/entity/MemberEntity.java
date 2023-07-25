package com.example.market.entity;

import com.example.market.dto.MemberDTO;
import lombok.Data;

@Data
public class MemberEntity {

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

    public static MemberEntity toSaveEntity(MemberDTO memberDTO) {

        MemberEntity memberEntity = new MemberEntity();

        memberEntity.setNo(memberDTO.getNo());
        memberEntity.setUserId(memberDTO.getUserId());
        memberEntity.setPw(memberDTO.getPw());
        memberEntity.setName(memberDTO.getName());
        memberEntity.setEmail(memberDTO.getEmail());
        memberEntity.setGender(memberDTO.getGender());
        memberEntity.setHp(memberDTO.getHp());
        memberEntity.setAddr1(memberDTO.getAddr1());
        memberEntity.setAddr2(memberDTO.getAddr2());
        memberEntity.setBirthday(memberDTO.getBirthday());

        return memberEntity;
    }

    public static MemberEntity toUpdateEntity(MemberDTO memberDTO) {

        MemberEntity memberEntity = new MemberEntity();

        memberEntity.setNo(memberDTO.getNo());
        memberEntity.setUserId(memberDTO.getUserId());
        memberEntity.setPw(memberDTO.getPw());
        memberEntity.setName(memberDTO.getName());
        memberEntity.setEmail(memberDTO.getEmail());
        memberEntity.setGender(memberDTO.getGender());
        memberEntity.setHp(memberDTO.getHp());
        memberEntity.setAddr1(memberDTO.getAddr1());
        memberEntity.setAddr2(memberDTO.getAddr2());
        memberEntity.setBirthday(memberDTO.getBirthday());

        return memberEntity;
    }

}
