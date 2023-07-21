package com.example.market.dto;

import com.example.market.entity.MemberEntity;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor      // 기본 생성자
@AllArgsConstructor     // 모든 필드를 매개변수로 하는 생성자
public class MemberDTO {

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

    public static MemberDTO toMemberDTO(MemberEntity memberEntity) {

        MemberDTO memberDTO = new MemberDTO();

        memberDTO.setNo(memberEntity.getNo());
        memberDTO.setUserId(memberEntity.getUserId());
        memberDTO.setPw(memberEntity.getPw());
        memberDTO.setName(memberEntity.getName());
        memberDTO.setEmail(memberEntity.getEmail());
        memberDTO.setGender(memberEntity.getGender());
        memberDTO.setHp(memberEntity.getHp());
        memberDTO.setAddr1(memberEntity.getAddr1());
        memberDTO.setAddr2(memberEntity.getAddr2());
        memberDTO.setBirthday(memberEntity.getBirthday());

        return memberDTO;
    }
}
