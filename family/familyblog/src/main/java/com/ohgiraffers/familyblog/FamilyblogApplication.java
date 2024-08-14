package com.ohgiraffers.familyblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FamilyblogApplication {

	public static void main(String[] args) {
		SpringApplication.run(FamilyblogApplication.class, args);
	}

}



//package com.ohgiraffers.familyblog;  이 클래스가 속한 패키지를 정의한다. 패키지는 클래스와 관련된 파일을 그룹화하는데 사용된다.com.ohgiraffers.post_st패키지에 속한 클래스임을 나타낸다.
//import org.springframework.boot.SpringApplication; Spring Application클래스를 import한다. 이클래스는 springboot애플리케이션 실행하는 데 사용된다.
//import org.springframework.boot.autoconfigure.SpringBootApplication;SpringBootApplication어노테이션을 import한다. 이 어노테이션은 Spring Boot애플리케이션의 기본 석정을 자동으로 구성하고 설정 클래스를 나타낸다.
//@SpringBootApplication: Spring Boot 애플리케이션의 주요설정을 포함하는 어노테이션이다. 이것은 세가지 주요기능을 포함한다. @Configuration;Spring의 설정 클래스를 나타낸다. @EnableAutoConfiguration;Spring Boot의 자동설정을 활성화한다.@ComponentScan현재패키지 및 하위 패키지에서 컴포넌트(빈)를 스캔한다.
//public class FamilyblogApplication{:FamilyblogApplication이라는이름의 클래스를 정의한다. 이 클래스는 애플리케이션의 엔트리 포인트 역할을 한다. 'public'키워드는 이 클래스가 모든 패키지에서 접근 가능함을 의미한다.
//public static void main(String[] args){: java 애플리케이션의 진입점인 main 메서드를 정의 이메서드는 jvm에 의해 호출되어 프로그램의 실행이 시작된다. string[]args는 프로그램에 전달된 커맨드라인 인수이다.
//SpringApplication.run(PostStApplication.class.args);springapplication.run메서드를 호출하여 springboot애플리케이션을 실행한다.