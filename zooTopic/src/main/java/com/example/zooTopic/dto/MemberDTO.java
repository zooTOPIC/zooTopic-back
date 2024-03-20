package com.example.zooTopic.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private String userEmail; // 데이터베이스 컬럼명에 맞게 수정
    private String userName; // 데이터베이스 컬럼명에 맞게 수정
    private String userPwd; // 데이터베이스 컬럼명에 맞게 수정
}