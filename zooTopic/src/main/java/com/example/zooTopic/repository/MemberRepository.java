package com.example.zooTopic.repository;

import com.example.zooTopic.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long>
{
    Optional<MemberEntity> findByUserEmail(String userEmail);

}
