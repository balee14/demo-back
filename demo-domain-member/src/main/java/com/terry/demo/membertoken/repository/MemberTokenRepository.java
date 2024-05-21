package com.terry.demo.membertoken.repository;

import com.terry.demo.core.entity.KpMemberToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberTokenRepository extends JpaRepository<KpMemberToken, String> {

    KpMemberToken findByIdEmailAndAccessTokenAndIsUse(String idEmail, String accessToken, Boolean isUse);

    KpMemberToken findByIdEmailAndRefreshToken(String idEmail, String refreshToken);

}
