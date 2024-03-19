package com.example.zooTopic;

import com.example.zooTopic.controller.memberController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ZooTopicApplication {

	private memberController MemberController;

	@Autowired
	public ZooTopicApplication(memberController MemberController) {
		this.MemberController = MemberController;
	}
	public static void main(String[] args) {
		SpringApplication.run(ZooTopicApplication.class, args);
	}

}
