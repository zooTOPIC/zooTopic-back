package com.example.zooTopic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ZooTopicApplication {

	private com.example.zooTopic.controller.MemberController MemberController;

	@Autowired
	public ZooTopicApplication(com.example.zooTopic.controller.MemberController MemberController) {
		this.MemberController = MemberController;
	}
	public static void main(String[] args) {
		SpringApplication.run(ZooTopicApplication.class, args);
	}

}
