package com.terry.demo.member.repository;

import static com.terry.demo.core.entity.QKpMember.kpMember;

import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.EnumPath;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.terry.demo.core.entity.KpMember;
import com.terry.demo.core.enumeration.MemberStateEnum;
import com.terry.demo.member.dto.MemberDto;
import com.terry.demo.member.dto.MemberPwdUpdateRequest;
import com.terry.demo.member.dto.MemberUpdateRequest;
import com.terry.demo.member.dto.QMemberDto;
import com.terry.demo.member.dto.MemberListRequest;
import com.terry.demo.member.dto.MembersDto;
import com.terry.demo.member.dto.QMembersDto;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryCustom {

    private final JPAQueryFactory jPAQueryFactory;

    /**
     * 정렬기능
     * @param sort
     * @return
     */
    private List<OrderSpecifier> getOrderSpecifier(Sort sort) {

        List<OrderSpecifier> orders = new ArrayList<>();

        // Sort
        sort.stream().forEach(
                order -> {
                    Order direaction = order.isAscending() ? Order.ASC : Order.DESC;
                    switch (order.getProperty()){
                        case "partnerName":
                            PathBuilder orderByExpression1 = new PathBuilder(KpMember.class, "partnerName");
                            orders.add(new OrderSpecifier(direaction, orderByExpression1));
                            break;
                        case "leaderName":
                            PathBuilder orderByExpression2 = new PathBuilder(KpMember.class, "leaderName");
                            orders.add(new OrderSpecifier(direaction, orderByExpression2));
                            break;
                    }
                }
        );
        return orders;

    }


//    /**
//     * 사용자유형 검색 LIST
//     * @param memberStateList
//     * @return
//     */
//    private BooleanExpression memberTypeIn(List<MemberState> memberStateList) {
//        return ObjectUtils.isEmpty(memberStateList) ? null : kpMember.memberState.in((Collection<? extends MemberState>) memberStateList);
//    }


    /**
     * 사용자 id, 이름  검색
     * @param memberSearchType, memberSearchInput
     * @return
     */
    private BooleanExpression memberNameIdLike(String memberSearchType, String memberSearchInput) {
        if (memberSearchType!= null && memberSearchType.equals("idEmail")) {
            return StringUtils.hasText(memberSearchType) ? kpMember.idEmail.like("%" + memberSearchType + "%") : null;
        }
        if (memberSearchType!= null && memberSearchType.equals("name")) {
            return StringUtils.hasText(memberSearchType) ? kpMember.name.like("%" + memberSearchType + "%") : null;
        }
        return null;
    }



    /**
     * 변수로 필터 구분
     * @param code           사용여부 또는 가입구분 코드
     * @param enumConverter  Enum 변환 함수
     * @param <T>            Enum 타입
     * @return
     */
    private <T extends Enum<T>> BooleanExpression isEnumIn(String code, Function<String, T> enumConverter, EnumPath<T> enumPath) {
        T enumValue = code != null && !code.isEmpty() ? enumConverter.apply(code) : null;
        return enumValue != null ? enumPath.eq(enumValue) : null;
    }

    /**
     * 사용자 목록 조회
     * @return
     */
    public Page<MembersDto> getMemberList(MemberListRequest memberListRequest, Pageable pageable) {
        List<MembersDto> memberList = jPAQueryFactory
                .select(new QMembersDto(
                        kpMember.memberId,
                        kpMember.idEmail,
                        kpMember.state,
                        kpMember.name,
                        kpMember.telephone,
                        kpMember.email
                        )
                )
                .from(kpMember)
                .where (
                    //회원 사용여부
                    isEnumIn(memberListRequest.getMemberTypeState(), MemberStateEnum::getMemberStateCodeFindAny, kpMember.state)
                )
                .orderBy(getOrderSpecifier(pageable.getSort()).stream().toArray(OrderSpecifier[]::new))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        JPAQuery<Long> count = jPAQueryFactory.select(kpMember.count()).from(kpMember);
        return PageableExecutionUtils.getPage(memberList, pageable, count::fetchOne);
    }

    /**
     *
     * @param memberId
     * @return
     */
    public MemberDto getMemberById(Long memberId) {
        return jPAQueryFactory
                .select(new QMemberDto(
                        kpMember.memberId
                    ,   kpMember.idEmail
                    ,   kpMember.state
                    ,   kpMember.name
                    ,   kpMember.telephone
                    ,   kpMember.email
                ))
                .from(kpMember)
                .where(kpMember.memberId.eq(memberId))
                .fetchOne();
    }

    /**
     *
     * @param memberUpdateRequest
     * @return
     */
    public long memberUpdate(MemberUpdateRequest memberUpdateRequest) {
        return jPAQueryFactory
                .update(kpMember)
                .set(kpMember.name, memberUpdateRequest.getName())
                .set(kpMember.telephone, memberUpdateRequest.getTelephone())
                .where(kpMember.memberId.eq(memberUpdateRequest.getMemberId()))
                .execute();
    }

    /**
     *
     * @param memberPwdUpdateRequest
     * @return
     */
    public long memberPwdUpdate(MemberPwdUpdateRequest memberPwdUpdateRequest) {
        return jPAQueryFactory
                .update(kpMember)
                .set(kpMember.pwd, memberPwdUpdateRequest.getPwd())
                .set(kpMember.modId, memberPwdUpdateRequest.getModId())
                .set(kpMember.modDt, LocalDateTime.now())
                .where(kpMember.memberId.eq(memberPwdUpdateRequest.getMemberId()))
                .execute();
    }



}
