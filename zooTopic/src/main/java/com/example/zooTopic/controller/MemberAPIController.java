package com.example.zooTopic.controller;

import com.example.zooTopic.dto.MemberDTO;
import com.example.zooTopic.entity.MemberEntity;
import com.example.zooTopic.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/member")
@RestController
public class MemberAPIController {
    @Autowired
    private MemberRepository memberRepository;

    @RequestMapping(value = "/select", method = {RequestMethod.GET, RequestMethod.POST})
    public List<MemberEntity> selectAll() {
        return memberRepository.findAll();
    }

    @RequestMapping(value = "/insert", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json; charset=utf-8")
    public MemberEntity insert(@RequestBody Map<String, String> map) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setUserEmail(map.get("UserEmail"));
        memberEntity.setUserName(map.get("UserName"));
        memberEntity.setUserPwd(map.get("UserPwd"));

        return memberRepository.save(memberEntity);
    }
}
