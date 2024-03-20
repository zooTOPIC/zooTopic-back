package com.example.zooTopic.dto;

import com.example.zooTopic.entity.MemberEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private String userEmail; // 데이터베이스 컬럼명에 맞게 수정
    private String userName; // 데이터베이스 컬럼명에 맞게 수정
    private String userPwd; // 데이터베이스 컬럼명에 맞게 수정

    public static MemberDTO fromMemberEntity(MemberEntity memberEntity) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setUserEmail(memberEntity.getUserEmail());
        memberDTO.setUserName(memberEntity.getUserName());
        memberDTO.setUserPwd(memberEntity.getUserPwd());
        return memberDTO;
    }

//    public static MemberDTO toMemberDTO(MemberEntity memberEntity){
//        MemberDTO memberDTO = new MemberDTO();
//        //memberDTO.setId(memberEntity.getId());
//        memberDTO.setUserEmail(memberEntity.getUserEmail());
//        memberDTO.setUserName(memberEntity.getUserName());
//        memberDTO.setUserPwd(memberEntity.getUserPwd());
//
//        return memberDTO;
//    }
}