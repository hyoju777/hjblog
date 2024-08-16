package com.ohgiraffers.familyblog.config; // 이 클래스가 속한 패키지를 정의한다.

import org.springframework.context.annotation.Bean; // 빈을 정의하기 위해 필요한 클래스를 가져온다.
import org.springframework.context.annotation.Configuration; //spring 설정 클래스를 정의하기 위해 필요한 클래스를 가져온다.
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry; //정적 자원핸들링을 위한 클래스를 가져온다.
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer; //spring mvc설정을 커스터마이즈하기 위한 인터페이스를 가져온다.

@Configuration // 이 클래스가 spring의 설정 클래스로 Bean 정의를 위한 클래스임을 나타낸다.
public class Webconfig implements WebMvcConfigurer { //webMvcConfigurer 인터페이스를 구현하여 spring mvc의 웹 설정을 커스터마이즈한다.

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) { // 정적 자원 핸들링을 설정한다.
        registry.addResourceHandler("/static/**")// "/static/**"패턴에 맞는 요청을 처리할 자원 핸들러를 추가한다.
                .addResourceLocations("classpath:/static/");// "classpath:/static/" 경로에서 자원을 찾도록 설정한다.
    }
}