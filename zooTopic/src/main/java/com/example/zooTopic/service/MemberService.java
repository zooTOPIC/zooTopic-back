package com.example.zooTopic.service;

import com.example.zooTopic.dto.MemberDTO;
import com.example.zooTopic.entity.MemberEntity;
import com.example.zooTopic.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service //스프링이 관리해주는 객체 == 스프링 빈
@RequiredArgsConstructor //controller와 같이. final 멤버변수 생성자 만드는 역할
public class MemberService {

    private final MemberRepository memberRepository; // 먼저 jpa, mysql dependency 추가

    public void save(MemberDTO memberDTO) {
        // repsitory의 save 메서드 호출
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
        memberRepository.save(memberEntity);
        //Repository의 save메서드 호출 (조건. entity객체를 넘겨줘야 함)

    }

//    public MemberDTO login(MemberDTO memberDTO){ //entity객체는 service에서만
//        Optional<MemberEntity> byUserEmail = memberRepository.findByUserEmail(memberDTO.getUserEmail());
//        if(byUserEmail.isPresent()){
//            // 조회 결과가 있다
//            MemberEntity memberEntity = byUserEmail.get(); // Optional에서 꺼냄
//            if(memberEntity.getUserPwd().equals(memberDTO.getUserPwd())) {
//                //비밀번호 일치
//                //entity -> dto 변환 후 리턴
//                return MemberDTO.fromMemberEntity(memberEntity);
//            } else {
//                //비밀번호 불일치
//                return null;
//            }
//        } else {
//            // 조회 결과가 없다
//            return null;
//        }
//    }

    public boolean authenticate(MemberDTO memberDTO) {
        MemberEntity memberEntity = memberRepository.findByUserEmail(memberDTO.getUserEmail())
                .orElse(null);
        if (memberEntity != null) {
            // 이메일에 해당하는 사용자가 존재하는 경우
            return memberEntity.getUserPwd().equals(memberDTO.getUserPwd());
        } else {
            // 이메일에 해당하는 사용자가 존재하지 않는 경우
            return false;
        }
    }
}