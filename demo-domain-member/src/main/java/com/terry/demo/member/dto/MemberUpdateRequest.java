package com.terry.demo.member.dto;


import com.terry.demo.core.enumeration.MemberStateEnum;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberUpdateRequest {

    private Long memberId;

    private String name;

    private String telephone;

    private String email;

    private String pwd;

    private Long partnerId;

    private MemberStateEnum state;

    private String position;

    private String memo;

    private String modId;

    private Boolean isDisabilityNoti;

    //사용자 category filter
    private List<MemberStateEnum> memberTypeStates;

    //사용자 검색 타입 (이름, 시용자 아디이)
    private String memberSearchType; //searchTypeParam

    private String memberSearchInput; //searchInputParam



}
