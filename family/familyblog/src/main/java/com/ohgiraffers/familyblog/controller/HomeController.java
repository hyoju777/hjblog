package com.ohgiraffers.familyblog.controller; // 패키지 선언: 이 클래스가 속한 패키지를 정의한다.

import org.springframework.stereotype.Controller; // Spring의 @Controller 어노테이션을 임포트 한다.
import org.springframework.web.bind.annotation.GetMapping; // Spring의 @GetMapping어노테이션을 임포트한다.

@Controller // 이 클래스가 Spring MVC의 컨트롤러 역할을 한다는 것을 나타낸다.
public class HomeController {

    @GetMapping("/") // HTTP GET 요청이 루트URL("/")로 들어올 때 이 메소드가 호출된다.
    public String home() {
        return "index"; //"index"라는 이름의 뷰 템플릿을 반환한다. 이 템플릿은 src/main/resources/templates폴더에 있어야 한다.
    }
}

//Homecontroller.java는 메인 페이지와 관련된 요청을 처리한다.
