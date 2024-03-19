package com.example.zooTopic.entity;

import com.example.zooTopic.dto.MemberDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "member_table") //database에 해당 이름의 테이블 생성
public class MemberEntity { //table 역할
    //jpa ==> database를 객체처럼 사용 가능

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;

    @Column(unique = true)
    private String UserEmail;
    @Column
    private String UserPwd;
    @Column
    private String UserName;



    public static MemberEntity toMemberEntity(MemberDTO memberDTO){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setUserEmail(memberDTO.getUserEmail());
        memberEntity.setUserPwd(memberDTO.getUserPwd());
        memberEntity.setUserName(memberDTO.getUserName());

        return memberEntity;
    }

}