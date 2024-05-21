package com.terry.demo.test.repository;

import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.PathBuilder;
import com.terry.demo.core.entity.KpTest;
import com.terry.demo.test.dto.QTestDto;
import com.terry.demo.test.dto.QTestsDto;
import com.terry.demo.test.dto.TestDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.terry.demo.test.dto.TestListRequest;
import com.terry.demo.test.dto.TestUpdateRequest;
import com.terry.demo.test.dto.TestsDto;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import static com.terry.demo.core.entity.QKpMember.kpMember;
import static com.terry.demo.core.entity.QKpTest.kpTest;

@Repository
@RequiredArgsConstructor
public class TestRepositoryCustom {

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
                        PathBuilder orderByExpression1 = new PathBuilder(KpTest.class, "partnerName");
                        orders.add(new OrderSpecifier(direaction, orderByExpression1));
                        break;
                    case "leaderName":
                        PathBuilder orderByExpression2 = new PathBuilder(KpTest.class, "leaderName");
                        orders.add(new OrderSpecifier(direaction, orderByExpression2));
                        break;
                }
            }
        );
        return orders;

    }

    /**
     * 사용자 목록 조회
     * @return
     */
    public Page<TestsDto> getTestList(TestListRequest testListRequest, Pageable pageable) {
        QueryResults<TestsDto> memberList = jPAQueryFactory
            .select(new QTestsDto(
                kpTest.testId,
                kpTest.idEmail
                )
            )
            .from(kpTest)
            .orderBy(getOrderSpecifier(pageable.getSort()).stream().toArray(OrderSpecifier[]::new))
            .offset(pageable.getOffset())
            .limit(pageable.getPageSize())
            .fetchResults();
        return new PageImpl<>(memberList.getResults(), pageable, memberList.getTotal());

    }

    /**
     *
     * @param testId
     * @return
     */
    public TestDto getTestById(Long testId) {
        return jPAQueryFactory
            .select(new QTestDto
                (   kpTest.testId
                ,   kpTest.idEmail)
            )
            .from(kpTest)
            .where(kpTest.testId.eq(testId))
            .fetchOne();
    }

    /**
     *
     * @param testUpdateRequest
     * @return
     */
    public long testUpdate(TestUpdateRequest testUpdateRequest) {
        return jPAQueryFactory
            .update(kpTest)
            .set(kpTest.idEmail, testUpdateRequest.getIdEmail())
            .set(kpTest.modId, testUpdateRequest.getModId())
            .where(kpTest.testId.eq(testUpdateRequest.getTestId()))
            .execute();
    }



}
