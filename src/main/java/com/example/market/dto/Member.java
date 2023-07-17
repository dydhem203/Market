package com.example.market.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data
public class Member {

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

    private Member() {

    }

    public static class Builder {

        private String userId;
        private String pw;
        private String name;
        private String email;
        private String gender;
        private String hp;
        private String addr1;
        private String addr2;
        private String birthday;

        public Builder(String userId, String pw) {
            this.userId = userId;
            this.pw = pw;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setGender(String Gender) {
            this.gender = gender;
            return this;
        }

        public Builder setHp(String hp) {
            this.hp = hp;
            return this;
        }
        public Builder setAddr1(String addr1) {
            this.addr1 = addr1;
            return this;
        }
        public Builder setAddr2(String addr2) {
            this.addr2 = addr2;
            return this;
        }
        public Builder setBirthday(String birthday) {
            this.birthday = birthday;
            return this;
        }

        public Member build() {
            Member memberDTO = new Member();

            memberDTO.userId = userId;
            memberDTO.pw = pw;
            memberDTO.name = name;
            memberDTO.email = email;
            memberDTO.gender = gender;
            memberDTO.hp = hp;
            memberDTO.addr1 = addr1;
            memberDTO.addr2 = addr2;
            memberDTO.birthday = birthday;

            return memberDTO;
        }
    }

}
