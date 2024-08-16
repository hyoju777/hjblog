package com.ohgiraffers.familyblog.controller;

import com.ohgiraffers.familyblog.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BlogController {

    @Autowired
    private BlogPostService blogPostService;

    @GetMapping("/blogs")
    public String listBlogPosts(Model model) {
        model.addAttribute("posts", blogPostService.getAllBlogPosts());
        return "blog/blogList";
    }

    @GetMapping("/blogs/{id}")
    public String viewBlogPost(@PathVariable Long id, Model model) {
        model.addAttribute("post", blogPostService.getBlogPostById(id));
        return "blog/blogDetail";
    }
}


//BlogController.java 블로그 페이지와 관련된 요청을 처리한다. 블로그 목록, 포스트 작성/조회 등을 담당한다.