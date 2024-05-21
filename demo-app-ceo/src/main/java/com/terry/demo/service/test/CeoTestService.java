package com.terry.demo.service.test;

import com.terry.demo.core.dto.CommonResponseEntity;
import com.terry.demo.core.dto.CommonResponseEntityType;
import com.terry.demo.core.entity.KpTest;
import com.terry.demo.test.dto.TestDto;
import com.terry.demo.test.dto.TestListRequest;
import com.terry.demo.test.dto.TestListResponse;
import com.terry.demo.test.dto.TestRequest;
import com.terry.demo.test.dto.TestResponse;
import com.terry.demo.test.dto.TestResponse.TestUpdateResponse;
import com.terry.demo.test.dto.TestUpdateRequest;
import com.terry.demo.test.dto.TestsDto;
import com.terry.demo.test.service.TestService;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
@Service
@RequiredArgsConstructor
@Transactional
public class CeoTestService {

    private final TestService testService;

    /**
     * admin test 목록 조회
     * @param
     * @return
     */
    @Transactional(readOnly = true)
    public ResponseEntity<?> getCeoTestList(TestListRequest testListRequest, Pageable pageable) {

        TestListResponse testListResponse = new TestListResponse();

        Page<TestsDto> testList = testService.getTestList(testListRequest, pageable);
        testListResponse.setTestList(testList.getContent());
        testListResponse.setAllCount(testList.getTotalElements());

        return new ResponseEntity<>(new CommonResponseEntity<>(CommonResponseEntityType.OK, testListResponse)
            , CommonResponseEntityType.OK.getHttpStatus());

    }

    /**
     * ceo test 조회
     * @param
     * @return
     */
    @Transactional(readOnly = true)
    public ResponseEntity<?> getCeoTestById(Long testId) {
        TestResponse.TestDtoResponse testDtoResponse  = new TestResponse.TestDtoResponse();

        TestDto testDto = testService.getTestById(testId);
        testDtoResponse.setTest(testDto);

        return new ResponseEntity<>(new CommonResponseEntity<>(CommonResponseEntityType.OK, testDtoResponse)
            , CommonResponseEntityType.OK.getHttpStatus());

    }

    /**
     * 등록
     * @param kpTest
     * @return
     */
    public ResponseEntity<?> ceoTestSave(KpTest kpTest) {

        TestResponse.TestEntityResponse testEntityResponse = new TestResponse.TestEntityResponse();

        KpTest kpTestSave = testService.testSave(kpTest);
        testEntityResponse.setTest(kpTestSave);

        return new ResponseEntity<>(new CommonResponseEntity<>(CommonResponseEntityType.OK, testEntityResponse)
            , CommonResponseEntityType.OK.getHttpStatus());

    }

    /**
     * 등록(파일)
     * @param testRequest
     * @return
     */
    public ResponseEntity<?> ceoTestFileSave(TestRequest testRequest) throws IOException {

        TestResponse.TestDtoResponse testDtoResponse = new TestResponse.TestDtoResponse();

        KpTest kpTest = testRequest.getKpTest();

        KpTest kpTestSave = testService.testSave(kpTest);
        TestDto testDto = new TestDto(kpTestSave);
        testDtoResponse.setTest(testDto);

        /*
        if (!ObjectUtils.isEmpty(kpTest.getMultipartFile())) {

            String fileName = kpTest.getMultipartFile().getOriginalFilename();
            // 초까지 같을 수가 있기 때문에 i를 통한 index 값 추가
            String s3FileName = "document-" + "1" + "-" + "0" + "-" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
            String fileUrl = "document/" + "1" + "/";
            String s3FileKey = fileUrl + s3FileName;
            // s3파일 업로드
            AwsS3BucketOrObject.uploadObjectFileToS3(s3FileKey, kpTest.getMultipartFile());

        }
         */

        return new ResponseEntity<>(new CommonResponseEntity<>(CommonResponseEntityType.OK, testDtoResponse)
                , CommonResponseEntityType.OK.getHttpStatus());

    }

    /**
     * 수정
     * @param testUpdateRequest
     * @return
     */
    public ResponseEntity<?> ceoTestUpdate(TestUpdateRequest testUpdateRequest) {

        TestUpdateResponse testUpdateResponse = new TestUpdateResponse();

        Long testCnt = testService.testUpdate(testUpdateRequest);
        testUpdateResponse.setTestCnt(testCnt);

        return new ResponseEntity<>(new CommonResponseEntity<>(CommonResponseEntityType.OK, testUpdateResponse)
            , CommonResponseEntityType.OK.getHttpStatus());

    }




}

