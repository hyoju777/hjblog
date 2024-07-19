package com.ohgiraffers.post_st.controller;


import com.ohgiraffers.post_st.model.dto.HjBlogDTO;
import com.ohgiraffers.post_st.model.entity.HjBlog;
import com.ohgiraffers.post_st.service.HjService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/hj") //  이 클래스 내의 모든 메소드는 /hj으로 시작하는 URL에 매핑
public class HjController {

    // HjService 타입의 필드로 선언. 서비스 계층의 메소드를 호출하기 위해 사용됨
    // 'private final'로 선언해서 반드시 초기화 해야되고(생성자에서), 변경할 수 없음
    // HjService 타입의 hjService라는 멤버 변수를 선언
    private final HjService hjService;

    // HjService의 인스턴스를 주입함
    // 스프링이 HjController를 생성할 때, HjService의 구현체를 자동으로 주입함

    // private final HjService hjService;로 변수를 선언하고
    // @Autowired로 변수를 초기화한다고 생각하면됨
    @Autowired
    // 생성자 주입 방식으로 'HjService'타입의 객체를 주입받음. 스프링 컨테이너가 'HjController'객체를 생성할 때, 'HjService'타입의 빈을 찾아 생성자의 배개변수로 주입
    public HjController(HjService hjService) {
        // 주입된 HjService 인스턴스를 클래스 필드에 할당하여 초기화함
        this.hjService = hjService;
    }

    //GET 요청을 처리하도록 매핑./main을 요청하면 이 메소드가 호울됨
    @GetMapping("main")
    public String mainpage() {
        // /hj/main 페이지를 차자 값을 반환
        return "/hj/main"; // (1) /hj안붙여서 오류 경로 정확히 쓰기
    }
    // /main요청을 날리면 /hj/main을 반환해줌

    @GetMapping("/post")
    public String showPostForm() {
        return "/hj/post";
    }

    // 게시물을 등록하는 부분
    @PostMapping
    // HjBlogDTO와 ModelAndView 객체를 매개변수로 받음 반환타입은 ModelAndView
    // 데이터 전송객체 HjBlogDTO, 요청 파라미터를 hjBlogDTO에 바인딩
    public ModelAndView postBlog(HjBlogDTO hjBlogDTO, ModelAndView mv) {
        // 블로그 제목이 null이거나 빈 문자열인 경우 리다이렉트
        if (hjBlogDTO.getBlogContent() == null || hjBlogDTO.getBlogTitle().equals("")) {
            mv.setViewName("redirect:/hj/post");
        }
        // 블로그 내용이 null이거나 빈 문자열인 경우 리다이렉트
        if (hjBlogDTO.getBlogContent() == null || hjBlogDTO.getBlogContent().equals("")) {
            mv.setViewName("redirect:/hj/post");
        }
        // 서비스 클래스의 post 메서드르 호출하여 블로그 게시글을 저장하고 결과를 받음
        int result = hjService.post(hjBlogDTO);
        // 결과가 0 이하인 경우 에러 페이지로 이동
        if (result <= 0) {
            mv.setViewName("error/page");
        } else {
            // 결과가 양수인 경우 성공 페이지로 이동
            mv.setViewName("hj/post");
        }
        // ModelAndView 객체를 반환합니다.
        return mv;
    }

    // 글 목록
    @GetMapping("/post-list")
    public String getBlogList(Model model) {
        // HjService를 통해 모든 블로그 게시글을 가져옴
        List<HjBlog> blogList = hjService.getAllBlogs();
        // Model 객체에 "blogList"라는 이름으로 가져온 블로그 목록을 추가
        model.addAttribute("blogList", blogList);
        // 뷰 이름을 반환함. 여기서는 "/hj/post-list"를 반환하여 해당 뷸ㄹ 표시하도록 함
        return "/hj/post-list";
    }

    // 글 상세조회
    // 1. 게시물 리스트에서 글 보기 버튼 추가
    // 2. 버튼을 누르면 작성된 글 조회하는 페이지로 넘어감

    // 글 상세조회

    // {blogid}는 경로 변수(path variable)로, URL에서 가변적인 값을 나타냅
    @GetMapping("/post-detail/{blogid}")
    public String getBlogDetail(@PathVariable Long blogid, Model model) {
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

    @GetMapping("/post-edit")
    public String showUpdateForm(@RequestParam("id") Long id, Model model) {
        HjBlog blog = hjService.getBlogById(id);
        HjBlogDTO blogDTO = new HjBlogDTO();
        blogDTO.setId(blog.getId());
        blogDTO.setBlogTitle(blog.getBlogTitle());
        blogDTO.setBlogContent(blog.getBlogContent());
        model.addAttribute("hjBlogDTO", blogDTO);
        return "/hj/post-edit";
    }

    @PostMapping("/update")
    public String updatePost(@ModelAttribute("hjBlogDTO") HjBlogDTO hjBlogDTO) {
        HjBlog updatedPost = hjService.updatePost(hjBlogDTO);
        // 수정 성공 시, 수정된 게시물 상세 페이지로 리다이렉트
        return "redirect:/hj/post-detail/" + updatedPost.getId();
    }

    // 게시글 삭제

    // 1. 게시물 목록 페이지에서 등록된 게시물 옆에 삭제 버튼을 누르면 게시물이 삭제되는 기능
    // 2. 삭제 버튼을 누르면 해당 id의 게시물의 데이터가 데이터베이스에서 삭제되고
    // 3. 게시물 목록에서도 없어져야됨

    @PostMapping("/delete/{id}")
    public String deleteBlog(@PathVariable Long id) {
        hjService.deleteBlog(id);
        return "redirect:/hj/post-list";
    }


}







