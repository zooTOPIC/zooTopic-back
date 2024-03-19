package com.example.zooTopic.dto;

import com.example.zooTopic.entity.MemberEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//lombok dependency추가
@Getter
@Setter
@NoArgsConstructor
@ToString
public class MemberDTO { //회원 정보를 필드로 정의
    private String UserEmail;
    private String UserName;
    private String UserPwd;

    //lombok 어노테이션으로 getter,setter,생성자,toString 메서드 생략 가능

    public static MemberDTO toMemberDTO(MemberEntity memberEntity){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setUserEmail(memberEntity.getUserEmail());
        memberDTO.setUserPwd(memberEntity.getUserPwd());
        memberDTO.setUserName(memberEntity.getUserName());
        return memberDTO;
    }
}