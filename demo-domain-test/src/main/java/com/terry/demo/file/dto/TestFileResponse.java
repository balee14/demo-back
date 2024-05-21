package com.terry.demo.file.dto;



import com.terry.demo.core.entity.KpTest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestFileResponse {

    @Getter
    @Setter
    public static class TestEntityResponse {
        private KpTest test;
    }

    @Getter
    @Setter
    public static class TestUpdateResponse {
        private Long testCnt;
    }

    @Getter
    @Setter
    public static class TestDeleteResponse {
        private Long testCnt;
    }

}

