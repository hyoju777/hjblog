package com.ohgiraffers.post_st;// 패키지 선언
import org.springframework.boot.SpringApplication;//스프링 부트 애플리케이션을 실행하는데 사용되는 유틸리티 클래스 임포트

import org.springframework.boot.autoconfigure.SpringBootApplication;// 스프링부트 애플리케이션의 자동설정을 활성화하는 어노테이션 임포트
@SpringBootApplication // 스프링 부트 애플리케이션으로서 이클래스가 설정 파일임을 나타내는 어노테이션
public class PostStApplication {// 클래스 선언: 포스트 애플리케이션이라는 이름의 공개 클래스
	/**
	 * 메인 메소드
	 * Spring Boot 애플리케이션을 시작합니다.
	 * @param args 커맨드 라인 인자
	 */

	public static void main(String[] args) {// 접근제어자 정적메서드 반환타입 메서드 이름 (자바프로그램의 진입점)매개변수
		// 자바애플리케이션의 시작지점
		SpringApplication.run(PostStApplication.class, args); // Spring Boot  애플리케이션을 시작한다.

	}

}
