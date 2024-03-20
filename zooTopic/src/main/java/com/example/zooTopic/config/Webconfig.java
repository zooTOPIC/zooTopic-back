package com.example.zooTopic.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Webconfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // 모든 요청에 대해 CORS 허용
                .allowedOrigins("http://172.16.221.58:3000")  // 클라이언트 출처
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // 허용할 HTTP 메서드
                .allowedHeaders("*");  // 모든 헤더 허용
    }
}
