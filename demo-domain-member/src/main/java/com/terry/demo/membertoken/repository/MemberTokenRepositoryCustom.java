package com.terry.demo.membertoken.repository;

import static com.terry.demo.core.entity.QKpMemberToken.kpMemberToken;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import com.terry.demo.membertoken.dto.MemberTokenErrorUpdate;
import com.terry.demo.membertoken.dto.MemberTokenIdEmailUpdateRequest;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

@Repository
@RequiredArgsConstructor
public class MemberTokenRepositoryCustom {

    private final JPAQueryFactory jPAQueryFactory;

/**
     * 토큰 관련 업데이트
     *
     * @param memberTokenIdEmailUpdateRequest
     */
    public void memberReAccessTokenUpdate(
        MemberTokenIdEmailUpdateRequest memberTokenIdEmailUpdateRequest) {

        JPAUpdateClause clause = jPAQueryFactory
            .update(kpMemberToken)
            .set(kpMemberToken.isUse, true)
            .set(kpMemberToken.accessToken, memberTokenIdEmailUpdateRequest.getReAccessToken())
            .set(kpMemberToken.accessTokenDt, LocalDateTime.now())
            .set(kpMemberToken.modDt, LocalDateTime.now())
            .set(kpMemberToken.modId, memberTokenIdEmailUpdateRequest.getIdEmail())
            .where(kpMemberToken.refreshToken.eq(memberTokenIdEmailUpdateRequest.getRefreshToken())
                    , kpMemberToken.idEmail.eq(memberTokenIdEmailUpdateRequest.getIdEmail())
                    //, kpMemberToken.isUse.eq()
            );
        clause.execute();

    }

    /**
     * 토큰 관련 업데이트
     *
     * @param memberTokenErrorUpdate
     */
    public void memberTokenErrorUpdate(MemberTokenErrorUpdate memberTokenErrorUpdate) {

        JPAUpdateClause clause = jPAQueryFactory
                .update(kpMemberToken)
                .set(kpMemberToken.modDt, LocalDateTime.now())
                .set(kpMemberToken.isUse, false);
                if (!ObjectUtils.isEmpty(memberTokenErrorUpdate.getIdEmail())) {
                    // 상위 개념인 idEmail이 먼저 처리 해야 함.
                    clause.set(kpMemberToken.modId, memberTokenErrorUpdate.getIdEmail());
                    clause.where(kpMemberToken.idEmail.eq(memberTokenErrorUpdate.getIdEmail())
                        , kpMemberToken.isUse.eq(true)
                    );
                } else if (!ObjectUtils.isEmpty(memberTokenErrorUpdate.getRefreshToken())){
                    clause.set(kpMemberToken.modId, memberTokenErrorUpdate.getRefreshToken());
                    clause.where(kpMemberToken.refreshToken.eq(memberTokenErrorUpdate.getRefreshToken())
                        , kpMemberToken.isUse.eq(true)
                    );
                } else {
                    clause.set(kpMemberToken.modId, memberTokenErrorUpdate.getAccessToken());
                    clause.where(kpMemberToken.accessToken.eq(memberTokenErrorUpdate.getAccessToken())
                        , kpMemberToken.isUse.eq(true)
                    );
                }
        clause.execute();

    }

}
