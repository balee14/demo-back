package com.terry.demo.test.dto;


import com.querydsl.core.annotations.QueryProjection;
import com.terry.demo.core.entity.KpTest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class TestsDto {

    private Long testId;

    private String idEmail;

    @QueryProjection
    public TestsDto(Long testId, String idEmail) {
        this.testId = testId;
        this.idEmail = idEmail;
    }

    public TestsDto(KpTest kpTest) {
        this.testId = kpTest.getTestId();
        this.idEmail = kpTest.getIdEmail();
    }


}

