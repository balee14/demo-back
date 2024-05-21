package com.terry.demo.member.dto;



import com.terry.demo.core.entity.KpMember;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberResponse {

    @Getter
    @Setter
    public static class MemberDtoResponse {
        private MemberDto member;
    }

    @Getter
    @Setter
    public static class MemberEntityResponse {
        private KpMember member;
    }

    @Getter
    @Setter
    public static class MemberUpdateResponse {
        private Long memberCnt;
    }

    @Getter
    @Setter
    public static class MemberDeleteResponse {
        private Long memberCnt;
    }

}

