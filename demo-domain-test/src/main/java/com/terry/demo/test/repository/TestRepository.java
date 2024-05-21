package com.terry.demo.test.repository;


import com.terry.demo.core.entity.KpTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TestRepository extends JpaRepository<KpTest, Long> {

    Optional<KpTest> findByIdEmail(String email);

}
