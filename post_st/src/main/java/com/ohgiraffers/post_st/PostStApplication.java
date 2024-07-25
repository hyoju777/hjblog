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
//1.패키지 정의(코드의 조직화와 충돌 방지를 위해 적절한 패키지 선언)
//package com.ohgiraffers.post_st;//패키지선언
//2.필요한 클래스임포트(애플리케이션 실행과 설정을 위한 필수 클래스 가져오기)
//import org.sprigframework.boot.SpringApplication;//스프부트 애플리케이션을 실행에사용되는 유틸리티 클래스 임포트
//impot org.springframewor.boot.autoconfigure.SpringBootApplication;// 스프링 부트 애플리케이션의 자동설정을 활성화하는 애노테이션 임포트
//3.스프링 부트 애플리케이션 클래스 선언(애플리케이션의 핵심설정을 정의하고 Spring Boot의 기능을 활성화)
//스프링 부트 애플리케이션으로서 이클래스가 설정 파일임을 나타내는 어노테이션
//@SpringBootApplication
//클래스선언 (PostStApplication이란이름의 공개 클래스)
//public class PostSTApplication
//4.메인 메소드 구현(자바 프로그램의 진입점을 정의하여 애플리케이션을 실행을 시작)
//접근제어자 정적메서드 반환타입 메서드 이름(자바크로그램의 진입점 매개변수)public static void main(String[] args){}
//5. 애플리케이션 실행 (springApplication.run메소드 호출로 Spring Boot 애플리케이션을 실행)
//Spring Boot 애플리케이션을 시작하는 유틸리티 클래스
//SpringApplication.run(PostApplication.class, args);
//애플리케이션의 주 클래스인 PostApplication을 로드하여 실행한다.//main 메소드의 매개변수로 전달된 명령줄 인자들을 받아서 사용한다.
