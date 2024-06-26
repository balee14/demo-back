package com.terry.demo.sign.service;

import com.terry.demo.core.util.KpMemberUtil;
import com.terry.demo.core.jwt.JwtTokenProvider;
import com.terry.demo.membertoken.dto.MemberTokenErrorUpdate;
import com.terry.demo.membertoken.service.MemberTokenService;
import com.terry.demo.sign.dto.SigninDto;
import com.terry.demo.sign.dto.SigninRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class SignService {

    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final MemberTokenService memberTokenService;

    /**
     * 로그인
     * @param signinRequest
     * @return
     */
    public SigninDto getMemberSignIn(SigninRequest signinRequest) {

        //
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(signinRequest.getIdEmail(), signinRequest.getPwd());

        // authenticate 메소드가 실행이 될 때 loadUserByUsername 메소드가 실행됨
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        //
        SecurityContextHolder.getContext().setAuthentication(authentication);
        log.debug("Security Context에 '{}' 인증 정보를 저장했습니다", signinRequest.getIdEmail());

        // 사용자 공통 설정
        SigninDto signinDto = new SigninDto();
        signinDto.setMemberId(KpMemberUtil.getMemberId());
        signinDto.setIdEmail(KpMemberUtil.getIdEmail());
        signinDto.setMemberAuthority(KpMemberUtil.getMemberAuthority());
        signinDto.setMemberName(KpMemberUtil.getMemberName());
        return signinDto;

    }

    /**
     * 로그아웃
     * @param request, response
     * @return
     */
    public void getMemberSignOut(HttpServletRequest request, HttpServletResponse response) {

        String accessToken = jwtTokenProvider.getHeaderAccessToken(request);
        MemberTokenErrorUpdate memberTokenErrorUpdate = new MemberTokenErrorUpdate();
        memberTokenErrorUpdate.setAccessToken(accessToken);
        memberTokenService.memberTokenErrorUpdate(memberTokenErrorUpdate);

        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }

    }



}
