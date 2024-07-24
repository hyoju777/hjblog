package com.ohgiraffers.post_st.controller; // 패키지 선언: com...controller패키지에 속한 클래스임을 나타냄



import com.ohgiraffers.post_st.model.dto.HjBlogDTO;// HjBlogDTO 클래스 임포트: 데이터 전송 객체
import com.ohgiraffers.post_st.model.entity.HjBlog; // HjBlog 클래스 임포트: 엔티티 클래스
import com.ohgiraffers.post_st.service.HjService; // HjService 클래스 임포트: 서비스 레이어
import org.springframework.beans.factory.annotation.Autowired; // @Autowired어노테이션 임포트: 스프링의 의존성 주입


import org.springframework.stereotype.Controller; // @Controller 어노테이션 임포트: 스프링 MVC 컨틀롤러
import org.springframework.ui.Model; // Model 인터페이스 임포트: 뷰에 데이터 전달
import org.springframework.web.bind.annotation.*; // 스프링 웹 애노테이션 임포트: 요청 매핑,경로변수, 요청 매개변수 등을 처리
import org.springframework.web.servlet.ModelAndView; // ModelAndView 클래스 임포트: 모델과 뷰를 함께 처리

import java.util.List; // List 인터페이스 임포트: 자바 유틸리티 클래스, 목록을 다룰 때 사용

@Controller// 이 클래스가 스프링 mvc의 컨트롤러 역할을 한다는 것을 나타내는 어노테이션
@RequestMapping("/hj") //  이 클래스 내의 모든 메소드는 /hj으로 시작하는 URL에 매핑된다.
public class HjController {// Hjcontroller클래스를 정의한다. 이 클래스는 웹 요청을 처리하는 컨트롤러 역할을 한다.여기에 컨트롤러 메소드가 추가된다.

    // HjService 타입의 필드로 선언. 서비스 계층의 메소드를 호출하기 위해 사용됨
    // 'private final'로 선언해서 반드시 초기화 해야되고(생성자에서), 변경할 수 없음
    // HjService 타입의 hjService라는 멤버 변수를 선언
    private final HjService hjService;//HjService타입의 불변(변경 불가능) 필드선언 // 이필드는 클래스가 인스턴스화 될 떄 주입된 HjService 객체 참조// 클래스 내부의 메소드에서 비즈니스 로직을 호출하는 데 사용 된다.// final 키워드 덕분에,객체는 생성 후에 변경할 수 없으며, //private 접근 제어자는 이 필드가 클래스 내부에서만 접근 가능하도록 제한한다.

    // HjService의 인스턴스를 주입함
    // 스프링이 HjController를 생성할 때, HjService의 구현체를 자동으로 주입함

    // private final HjService hjService;로 변수를 선언하고
    // @Autowired로 변수를 초기화한다고 생각하면됨
    @Autowired
    // 생성자 주입 방식으로 'HjService'타입의 객체를 주입받음. 스프링 컨테이너가 'HjController'객체를 생성할 때, 'HjService'타입의 빈을 찾아 생성자의 매개변수로 주입
    public HjController(HjService hjService) {
        // 주입된 HjService 인스턴스를 클래스 필드에 할당하여 초기화함
        this.hjService = hjService;// 생정자에게 주입 받은 HjService 객체를 클래스의 hjService 필드에 할당
    }

    //GET 요청을 처리하도록 매핑./main을 요청하면 이 메소드가 호출됨
    @GetMapping("main")
    public String mainpage() {// 메소드 이름은 mainpage 반환 타입은 String, 메소드 내용이 여기에 위치할 것이다.
        // /hj/main 페이지를 차자 값을 반환
        return "/hj/main"; // (1) /hj안붙여서 오류 경로 정확히 쓰기
    }
    // /main요청을 날리면 /hj/main을 반환해줌

    @GetMapping("/post")// HTTP GET 요청을 처리하기 위해 사용되는 스프링 MVC 어노테이션 @GetMapping은 스프링 MVC에서 HTTP GET요청(일반적 서버에서 데이터 조회할떄 사용)을 처리하기 위해 사용하는 어노테이션이다. post는 URL경로:이 메소드는 "/post" 경로로 들어오는 GET 요청을 처리한다.
    public String showPostForm() {// 메소드 이름은 'showPostForm',반환 타입은 String // 메소드 내용이 여기에 위치할 것이다.// 'showPostForm'이라는 이름의 메소드를 정의합니다. 이 메소드는 String 타입의 값을 반환합니다.
        // 'public' 접근 제어자를 사용하여, 이 메소드는 클래스 외부에서도 호출할 수 있다.
        // 반환 타입 'String'은 메소드가 뷰의 이름을 문자열로 반환함을 의미하며,
        // 스프링 MVC에서는 이 문자열이 렌더링할 뷰의 이름으로 사용된다.
        // 메소드 이름 'showPostForm'은 이 메소드가 게시물 작성 폼을 표시하는 역할을 수행할 것임을 나타낸다.
        // 메소드 본문에는 폼을 렌더링할 뷰의 이름을 반환하는 코드가 들어갈 것이다.
        return "/hj/post";//뷰의 이름으로 "hj/post"를 반환하여 해당 경로의 뷰를 렌더링하도록 한다.
    }

    // 게시물을 등록하는 부분
    @PostMapping//스프링 MVC에서 HTTP POST요청을 처리하는 데 사용 ,HTTP POST 요청을 처리하는 메소드에 매핑POST 요청은 주로 서버에 데이터를 전송하거나 서버의 상태를 변경하는 데 사용됩니다. 예를 들어, 폼 데이터를 제출하거나, 리소스를 생성하는 요청에 사용됩니다.
    // HjBlogDTO와 ModelAndView 객체를 매개변수로 받음 반환타입은 ModelAndView
    // 데이터 전송객체 HjBlogDTO, 요청 파라미터를 hjBlogDTO에 바인딩
    public ModelAndView postBlog(HjBlogDTO hjBlogDTO, ModelAndView mv) { // 접근제어자 이메소드는 클래스 외부에서도 접근할 수 있다.
        // 블로그 제목이 null이거나 빈 문자열인 경우 리다이렉트
        if (hjBlogDTO.getBlogContent() == null || hjBlogDTO.getBlogTitle().equals("")) {// if 조건문은 블로그 데이터가 유효한지 검사한다. 블로그 내용이 null이거나 블로그 제목이 빈 문자열이면 조건문 내의 코드 블록이 실행 된다.
            // 사용자가 블로그 포스트를 제출 할 때 필수적인 정보가 누락되었는지 확인하는 로직이다. 예를 들어 블로그 포스트의 내용이 없거나 제목이 빈 경우 유효성 검사를 실패로 처리하여 적절한 조치를 취할 수 있도록 한다.
            mv.setViewName("redirect:/hj/post"); //mv는 modelAndView 객체이다. setvieName 메소드를 호출하여 뷰의 이름을 설저한다. redirect:/hj/post"는 리다이렉트 url이다. mv setviewName("rediret:/hj/post")':'mv'객체에 리다이렉트할 url을 설정한다. 이 설정은 클라이언트가 "hj/post"url로 리다이렉트 되도록 한다. 즉 ,현재 요청이 처리된 후 클라이언트는 "hj/post"경로로 이동한다.
        }
        // 블로그 내용이 null이거나 빈 문자열인 경우 리다이렉트
        if (hjBlogDTO.getBlogContent() == null || hjBlogDTO.getBlogContent().equals("")) {
            mv.setViewName("redirect:/hj/post");
        }
        // 서비스 클래스의 post 메서드르 호출하여 블로그 게시글을 저장하고 결과를 받음
        int result = hjService.post(hjBlogDTO);// hjservice는 서비스 객체로 비즈니스 로직을 담당한다. hjservice.post(hjBlogDTO)메소드를 호출하여 블로그 포스트 데이터를 처리한다.hjBlogDTO는 블로그 포스트의 데이터 전송 객체로 사용자가 입력한 데이터를 담고 있다. 이 메소드 호출의 반환값을 result변수에 저장한다. result는 메소드 호출 결과를 나타내는 정수 값이다.(성공여부를 나타내는 코드)
        // 결과가 0 이하인 경우 에러 페이지로 이동
        if (result <= 0) { // 'result'가 0이하인 경우(즉,처리 실패 또는 에러 발생)
            mv.setViewName("error/page");//'mv'객체에 에러 페이지의 뷰 이름을 설정한다.
        } else {
            // 결과가 양수인 경우 성공 페이지로 이동(result가 양수인 경우 즉,처리성공)
            mv.setViewName("hj/post"); // 'mv'객체에 성공 페이지의 뷰 이름을 설정한다.
        }
        // ModelAndView 객체를 반환합니다.// 클라이언트는 설정된 뷰를 통해 결과를 보게 된다.
        return mv;
    }

    // 글 목록 .클라이어 언트가 /post-list url로 get요청을 보낼 때 getpostlist메서드가 호출되어 포스트의 리스트를 반환한다.
    @GetMapping("/post-list")
    //블로그 목록을 가져와서 모델에 추가하는 메서드
    public String getBlogList(Model model) {
        // HjService를 통해 모든 블로그 게시글을 가져옴
        List<HjBlog> blogList = hjService.getAllBlogs();
        // Model 객체에 "blogList"라는 이름으로 가져온 블로그 목록을 추가
        model.addAttribute("blogList", blogList);
        // 뷰 이름을 반환함. 여기서는 "/hj/post-list"를 반환하여 해당 블로그표시하도록 함
        return "/hj/post-list";
    }

    // 글 상세조회
    // 1. 게시물 리스트에서 글 보기 버튼 추가
    // 2. 버튼을 누르면 작성된 글 조회하는 페이지로 넘어감

    // 글 상세조회

    // {blogid}는 경로 변수(path variable)로, URL에서 가변적인 값을 나타냅
    @GetMapping("/post-detail/{blogid}")//블로그 게시물의 상세 정보를 가져오는 메서드입니다.
    public String getBlogDetail(@PathVariable Long blogid, Model model) {// 특정 블로그 게시물의 상세 정보를 가져와 모델에 추가하는 메서드
//접근제어자(이메서드는 다른클래스에서도 접근할 수 있다.)반환타입(이메서드는 문자열을 반환한다.)

        // ID를 이용하여 해당 블로그 게시글을 조회
        HjBlog blog = hjService.getBlogById(blogid);
        // 조회한 블로그 게시글을 모델에 추가
        model.addAttribute("blog", blog);
        // 상세조회 페이지로 이동
        return "/hj/post-detail";
    }

    // 작성된 글 수정
    // 1. 글 목록중에 수정하고 싶은 게시물로 들어가기
    // 2. 글 수정 페이지 새로 만들기
    // 3. 작성된 글의 데이터를 가져오기
    // - 글 작성 페이지 형식으로 돼있는데 작성한 글이 들어가있어야됨
    // 4.3에서 가져온 글을 수정하고 다시 저장
    // - 새로운 게시물로 저장되지않고 원래 있던 게시물에 저장돼야함

    @GetMapping("/post-edit")//@GetMapping: 이 어노테이션은 HTTP GET 요청을 처리하기 위한 메서드를 지정합니다. GET 요청은 주로 서버에서 데이터를 조회하거나 페이지를 가져오는 데 사용됩니다.
//("post-edit"): URL 경로를 지정합니다. 클라이언트가 이 경로로 GET 요청을 보내면, 이 메서드가 호출됩니다. 예를 들어, 사용자가 웹 브라우저에 http://yourdomain.com/post-edit를 입력하면 이 메서드가 실행됩니다.
    public String showUpdateForm(@RequestParam("id") Long id, Model model) {// 특정 블로그 게시물의 수정 폼을 보여주는 메서드.요청 파라미터에 id값을 Long타입으로 받고 뷰에 데이터를 전달하기위한 모델 객체
        // 접근제어자(이 메서드는 다른 클래스나 패키지에서 접근할 수있다.)메서드의 반환타입 (이메서드는 문자열을 반환하며 반환된 문자열은 뷰의 이름을 나타냄)메서드이름(이메서드는 수정 폼을 보여주는 역할을함)이 어노테이션은 Http요청의 파라미터를 메서드의 매개변수에 바인딩한다.HttP요청 파라미터이름이다(클라이언트가 요청시 id라는 이름의 값을 전달) 파라미터 타입은 요청 파라미터id를 long타입으로 변환 그후 요청 파라미트 id의 값을 이 변수에 저장.스프링mvc에서 뷰에 데이터를 전달하기 위해 사용하는 객체(컨트롤러에서 처리한 데이터를 뷰로 전달) Model타입의 매개변수 이름 (이 객체를 통해 데이터블로그게시물 정보를 뷰로 전달)
        HjBlog blog = hjService.getBlogById(id);// 자바에서 객체를 생성하고 메서드를 호출하여 값을 얻음
        // HJBlog블로그 정보를 담는 데이터 모델 클래스 blog는 HjBlog타입의 변수로 블로그 객체를 저장하기 위해 사용된다. hjService는 블로그관련 서비스제공 나타낸다.(비즈니스 로직을 처리하는 클래스) get BlogById는 메서드 이름을 나타냄다. hjService객체가 가진 메서드로 주어진 ID를 사용하여 블로그 정보를 검색한다.id 블로그를 식별하기 위한 입력 값이다.이값에 따라 특정 블로그를 찾는데 사용됨
        HjBlogDTO blogDTO = new HjBlogDTO();//HjBlogDTO는 데이터 전송 객체 클래스의 이름을 나타냄.DTO는 데이터를 전송하거나 저장하기 위해 사용되는 클래스이다.new는 새로운 객체를 생성하기 위해 사용하는 키워드이고 HJBlogDTO()는 HjBlogDTO 클래스의 생성자를 호출하여 새로운 객체를 생성함
        // HjBlogDTO블로그와관련된 데이터를 담는 데이터전송 객체 클래스이고 블로그 정보를 캡슐화하는데 사용된다. bloDTO는 HjBloDTO타입의 변수로 블로그 정보를 저장하기 위한 객체이다. new는 클래스의 생서자를 호출하여 메모리에 새로운 인스턴스를 생성한다.HjBlogDTO()는 HjBlogDTO클래스의 생성자를 호출하여 새로운 HjBlogDTO객체를 생성하다. 생성자는 클래스의 인스턴스를 초기화하는 메서드이다.
        // HJBlogDTO클래스의 새로운 객체를 생성하고 이를 blogDTO라는 변수에 할당하여 이후에 이 객체를 사용할 준비를 하는 것이다.
        blogDTO.setId(blog.getId());// blog객체에서id값을 가져와 blogDTO객체의 id에 설정하는 것
        //blogDTO는 HjBlogDTO클래스의 객체이다. 이 객체는 블로그 정보를 저장하고 전송하는데 사용됨.setID는 HjBlogDTO클래스에서 제공하는 메서드로 객체의 id 필드에 값을 설정한다.blog는 HjBlog 클래스의 객체이다. 이 객체는 블로그 정보를 담고 있다.getId는
        // HjBlog클래스에서 제공하는 메서드로 객체의 id 필드 값을 반환한다.
        blogDTO.setBlogTitle(blog.getBlogTitle());// blog 객체에서 blogtitle값을 가져와 blogDTo 객체의 blogTitle에 설정하는 것을 의미
        blogDTO.setBlogContent(blog.getBlogContent());// blog 객체에서 blogContent 값을 가져와 blogDTO객체의 blogContent에 설정하는 것을 의미.
        model.addAttribute("hjBlogDTO", blogDTO);// blogDTO객체를 모델에 추가하여 뷰에서 사용할 수 있데 하는 것을 의미
        // model은 Spring Framework에서 제공하는 Model객체이다. 이 객체는 컨트롤러에서 뷰로 데이터를 전달하는데 사용 된다. addAttribute는 Model객체의 메서드로 뷰에서 사용할 수 있도록 데이터를 추가한다.
        //"hjBlogDTO는 뷰에서 참조할 이름으로 이이름으로 blogDTO객체를 뷰에 전달한다.bloDTo는 HjBlogDTO,클래스의 객체이다. 이 객체는 블로그 정보를 저장하고 전송하는 데 사용 된다.

        return "/hj/post-edit";// 컨트롤러 메서드가 처리한 후 이동할 뷰(View)의 이름을 반환하는 것을 의미,리턴은 메서드가 값을 반환할 떄 사용되는 키워드 hj..edit는 뷰의 이름을 나타내는 문자열 이뷰이름은 Spring MVc의 뷰리졸버에 의해 실페 뷰 파일로 매핑 됨
    }

    @PostMapping("/update")// 이 어노테이션은 HTTP POST 요청을 처리하는 메서드를 정의한다./update경로로 들어오는 POST요청을 이 메서드가 처리한다.
    public String updatePost(@ModelAttribute("hjBlogDTO") HjBlogDTO hjBlogDTO) {// 클라이언트로 부터 전달된 게시물 데이터르 HjBlogDTO객체에 매피하고 이 객체를 사용하여 게시물 정보를 업데이한 후 게시물 목록 페이지로 리다이렉트하는 역할읗 한다. @ModelAttribute는 클라이언트 요청의 데이터를 모델 객체로 변환하여 컨트롤러 메서드의 인자로 전달해 준다.
        //접근제어자 메서드 반환타입 메서드 이름(클라이언트 요청 데이터를 HjBlogDTO객체로 변환하여 전달 HJlogDT는 데이터 전송 객체의 타입 hjBlogDTO는 HjBlogDTO객체를 담는 매개변수 이름
        HjBlog updatedPost = hjService.updatePost(hjBlogDTO);// HjBlog 객체를 담는 변수 updatePost를 선언하고,hjService 객체의 updatePost 메서드를 호출하여 반환된 값을 할당
        // 수정 성공 시, 수정된 게시물 상세 페이지로 리다이렉트
        return "redirect:/hj/post-detail/" + updatedPost.getId();//updatePost 메서드가 성공적으로 실행된 후, 업데이트된 게시글의 상세 페이지로 리다이렉트하는 URL을 반환합니다. "redirect:/hj/post-detail/" 문자열과 updatedPost.getId() 메서드로 가져온 게시글의 ID를 결합하여 최종 리다이렉트 경로를 생성합니다.
        // "redirect:/hj/post-detail/": 리다이렉션 경로를 지정하는 문자열
// +: 문자열을 연결하는 연산자,// updatedPost: 업데이트된 게시글 객체, 이전에 정의된 HjBlog 객체,// .getId(): updatedPost 객체의 ID를 가져오는 메서드 호출
    }

    // 게시글 삭제

    // 1. 게시물 목록 페이지에서 등록된 게시물 옆에 삭제 버튼을 누르면 게시물이 삭제되는 기능
    // 2. 삭제 버튼을 누르면 해당 id의 게시물의 데이터가 데이터베이스에서 삭제되고
    // 3. 게시물 목록에서도 없어져야됨

    @PostMapping("/delete/{id}")// 클라이언트가 HTTP POST 요청을 처리하는메서드 지정한다. "/delete/{id}"경로로 보내면 이 메서드가 호출된다.//{id}는 URL 경로에서 동적으로 값을 받아오는 변수이다. 이 메서드는 id 값을 이용해 특정 리소스를 삭제하고 삭제후 클라이언트를 hj/post-list로 리다이렉트하다.
    public String deleteBlog(@PathVariable Long id) {// HTTP DELETE 요청을 처리하는 메서드,@pathVariable 어노테이션은 URL경로에 포함된 변수 값을 메서드의 매개변수로 전달한다.이 변수는 게시물의 고유 ID를 나타낸다.
        hjService.deleteBlog(id); //hjService 객체를 사용하여 데이터베이스에서 지정된 ID의 블로그 게시글을 삭제한다.//hjService는 비즈니스 로직을 처리하는 서비스 클래스이다.
        return "redirect:/hj/post-list"; // 블로그 게시글 삭제가 완료된 후, 사용자를 블로그 게시글 목록 페이지로 리다이렉트한다. // redirect:/hj/post-list는 브라우저에게 새로운 URL로 이동하라는 명령을 보낸다.
    }


}







