package com.example.zooTopic.entity;

import com.example.zooTopic.dto.MemberDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "user_data")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, name = "UserEmail") // 데이터베이스 컬럼명에 맞게 수정
    private String userEmail;

    @Column(name = "UserPwd") // 데이터베이스 컬럼명에 맞게 수정
    private String userPwd;

    @Column(name = "UserName") // 데이터베이스 컬럼명에 맞게 수정
    private String userName;

    public static MemberEntity toMemberEntity(MemberDTO memberDTO){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setUserEmail(memberDTO.getUserEmail());
        memberEntity.setUserPwd(memberDTO.getUserPwd());
        memberEntity.setUserName(memberDTO.getUserName());
        return memberEntity;
    }
}
