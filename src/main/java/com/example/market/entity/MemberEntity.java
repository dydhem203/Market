package com.example.market.entity;

import com.example.market.dto.Cart;
import com.example.market.dto.MemberDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="user")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // mysql - auto_increment
    private int no;

    @Column(length = 45, nullable = false)
    private String userId;

    @Column(length = 100, nullable = false)
    private String pw;

    @Column(length = 45, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 1)
    private String gender;

    @Column(length = 20, nullable = false)
    private String hp;

    @Column(length = 100, nullable = false)
    private String addr1;

    @Column(length = 100, nullable = false)
    private String addr2;

    @Column(length = 10)
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
