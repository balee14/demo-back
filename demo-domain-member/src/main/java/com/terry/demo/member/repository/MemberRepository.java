package com.terry.demo.member.repository;


import com.terry.demo.core.entity.KpMember;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<KpMember, Long> {

    Optional<KpMember> findByIdEmail(String email);

}
