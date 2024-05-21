package com.terry.demo.test.dto;


import com.terry.demo.core.entity.KpTest;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class TestDto {

    private Long testId;

    private String idEmail;

    @QueryProjection
    public TestDto(Long testId, String idEmail) {
        this.testId = testId;
        this.idEmail = idEmail;
    }

    public TestDto(KpTest kpTest) {
        this.testId = kpTest.getTestId();
        this.idEmail = kpTest.getIdEmail();
    }


}

