package com.terry.demo.member.dto;

import com.querydsl.core.annotations.QueryProjection;
import com.terry.demo.core.enumeration.MemberStateEnum;
import java.time.LocalDateTime;

public record MembersDto(Long memberId
    ,   String idEmail
    ,   MemberStateEnum state
    ,   String name
    ,   String telephone
    ,   String email) {

    @QueryProjection
    public MembersDto(Long memberId, String idEmail
            , MemberStateEnum state, String name
            , String telephone, String email) {
        this.memberId = memberId;
        this.idEmail = idEmail;
        this.state = state;
        this.name = name;
        this.telephone = telephone;
        this.email = email;
    }
}

