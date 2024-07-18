package com.ohgiraffers.post_st;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;//@SpringBootApplication 애노테이션: 이 애노테이션은 Spring Boot 애플리케이션의 주 진입점이 되는 클래스에 지정됩니다.
//Spring Boot에서의 'autoconfigure'는 특히 중요한 개념입니다. Spring Boot는 애플리케이션을 자동으로 구성하는 기능을 제공하는데, 이는 개발자가 명시적으로 설정하지 않아도 기본적인 설정을 제공하고 필요한 빈(bean)들을 자동으로 등록하거나 구성합니다.
@SpringBootApplication
public class HjblogprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(HjblogprojectApplication.class, args);
	}

}
