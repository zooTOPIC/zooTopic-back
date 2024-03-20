package com.example.zooTopic.controller;

import com.example.zooTopic.dto.MemberDTO;
import com.example.zooTopic.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


@Controller
@RequiredArgsConstructor //MemberService에 대한 멤버를 사용 가능
public class MemberController {

    // 생성자 주입
    private final MemberService memberService;

    // 회원가입 페이지 출력 요청
    @GetMapping("/member/save")
    public String saveForm() {
        return "save";
    }

    @PostMapping("/member/save")
    public ResponseEntity<Void> save(@ModelAttribute MemberDTO memberDTO) {
        System.out.println("MemberController.save");
        System.out.println("memberDTO = " + memberDTO);
        memberService.save(memberDTO);

        // 리다이렉션을 위한 응답을 생성하고, 리다이렉션할 URL을 Location 헤더에 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("http://172.16.221.58:3000/login"));

        // HTTP 상태 코드 302(Found)를 사용하여 리다이렉션을 수행
        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }

    @GetMapping("/member/login")
    public String loginForm(){
        return "login";
    }


//    @PostMapping("/member/login") // session : 로그인 유지
//    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
//        MemberDTO loginResult = memberService.login(memberDTO);
//        if (loginResult != null) {
//            // login 성공
//            session.setAttribute("loginEmail", loginResult.getUserEmail());
//            HttpHeaders headers = new HttpHeaders();
//            headers.setLocation(URI.create("http://172.16.221.58:3000/"));
//
//            // HTTP 상태 코드 302(Found)를 사용하여 리다이렉션을 수행
//            return String.valueOf(new ResponseEntity<>(headers, HttpStatus.FOUND));
//        } else {
//            // login 실패
//            HttpHeaders headers = new HttpHeaders();
//            headers.setLocation(URI.create("http://172.16.221.58:3000/login"));
//
//            // HTTP 상태 코드 302(Found)를 사용하여 리다이렉션을 수행
//            return String.valueOf(new ResponseEntity<>(headers, HttpStatus.FOUND));
//        }
//
//    }

    @PostMapping("/member/login")
    public ResponseEntity<String> login(@RequestBody MemberDTO memberDTO) {
        boolean isAuthenticated = memberService.authenticate(memberDTO);
        if (isAuthenticated) {
            return ResponseEntity.ok().body("로그인 성공");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("이메일 또는 비밀번호가 잘못되었습니다.");
        }
    }


}
