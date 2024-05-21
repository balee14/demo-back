package com.terry.demo.controller;

import com.terry.demo.core.entity.KpTest;
import com.terry.demo.service.test.CeoTestService;
import com.terry.demo.test.dto.TestListRequest;
import com.terry.demo.test.dto.TestUpdateRequest;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/ceo/v1")
public class CeoTestController {

    /**
     * 테스트 관리
     */

    private final CeoTestService ceoTestService;

    /**
     * 모든 test 목록 조회
     *
     * @param
     * @return
     */
    @GetMapping("/test/tests")
    public ResponseEntity<?> getCeoTestList(@ModelAttribute TestListRequest testListRequest, Pageable pageable) {
        return ceoTestService.getCeoTestList(testListRequest, pageable);
    }

    /**
     * test 조회
     *
     * @param
     * @return
     */
    @GetMapping("/test/testId/{testId}")
    public ResponseEntity<?> getCeoTestById(@PathVariable("testId") Long testId) {
        return ceoTestService.getCeoTestById(testId);
    }

    /**
     * test 등록
     *
     * @param kpTest
     * @return
     */
    @PostMapping("/test")
    public ResponseEntity<?> ceoTestSave(@RequestBody KpTest kpTest) throws IOException {
        return ceoTestService.ceoTestSave(kpTest);
    }

    /**
     * test 업데이트
     *
     * @param testUpdateRequest
     * @return
     */
    @PutMapping("/test")
    public ResponseEntity<?> ceoTestUpdate(@RequestBody TestUpdateRequest testUpdateRequest) {
        return ceoTestService.ceoTestUpdate(testUpdateRequest);
    }



}


