-- innodb.kp_member definition
SET foreign_key_checks = 0;    # 외래키 체크 설정 해제
SET foreign_key_checks = 1;    # 외래키 체크 설정

DROP TABLE kp_member;

-- innodb.kp_member definition

CREATE TABLE `kp_member` (
                             `member_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
                             `id_email` varchar(250) NOT NULL COMMENT '사용자ID',
                             `pwd` varchar(250) NOT NULL COMMENT '회원PW',
                             `state` varchar(1) NOT NULL COMMENT '사용여부(사용:Y, 미사용:N)',
                             `name` varchar(250) NOT NULL COMMENT '회원명(nickname)',
                             `telephone` varchar(15) NOT NULL COMMENT '회원 연락처',
                             `email` varchar(250) DEFAULT NULL COMMENT '회원 이메일',
                             `mod_dt` datetime(6) NOT NULL DEFAULT current_timestamp(6) COMMENT '수정일',
                             `mod_id` varchar(250) NOT NULL DEFAULT 'anonymousUser' COMMENT '수정자',
                             `reg_dt` datetime(6) NOT NULL DEFAULT current_timestamp(6) COMMENT '등록일',
                             `reg_id` varchar(250) NOT NULL DEFAULT 'anonymousUser' COMMENT '등록자',
                             PRIMARY KEY (`member_id`),
                             UNIQUE KEY `UK_56rtre601c88cet1w0ee0iit0` (`id_email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='회원';
