package com.ohgiraffers.post_st.service;


import com.ohgiraffers.post_st.model.dto.HjBlogDTO;
import com.ohgiraffers.post_st.model.entity.HjBlog;
import com.ohgiraffers.post_st.repository.HjRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class HjService {

    // HjRepository 인터페이스 구현한 빈을 주입받음
    private final HjRepository hjRepository;

    @Autowired
    public HjService(HjRepository hjRepository) {
        this.hjRepository = hjRepository;
    }


    // 메서드가 하나의 트랜잭션으로 실행되어야 함을 나타냄.메서드 실행 중 발생할 수 있는 데이터베이스 관련 예외를 처리하고 롤백할 수 있다.
    @Transactional
    public int post(HjBlogDTO hjblogDTO) {
        //블로그 제목이 중복되는지 검사하기 위해 모든 블로그를 가져옵니다.
        //HjBlog 객체들로 구성된 리스트를 저장 hjBlogs는 이 리스트를 가리키는 변수
        //hjRepository는 HjBlogRepository 타입의 인스턴스.JpaRepository<HjBlog,Integer>를 상속받음
        List<HjBlog> hjBlogs = hjRepository.findAll();

        // 도메인 로직: 블로그 제목이 이미 존재하는지 확인합니다.
        for (HjBlog blog : hjBlogs) {
            if (blog.getBlogTitle().equals(hjblogDTO.getBlogTitle())) {
                // 이미 같은 제목의 블로그가 존재하면 0을 반환하여 실패를 알립니다.
                return 0;
            }
        }

        // 새로운 HjBlog 객체를 생성하고 DTO로부터 받은 데이터를 설정합니다.
        HjBlog saveBlog = new HjBlog();
        saveBlog.setBlogContent(hjblogDTO.getBlogContent());
        saveBlog.setBlogTitle(hjblogDTO.getBlogTitle());
        saveBlog.setCreateDate(new Date());

        // 새로운 블로그를 저장하고 저장 결과를 받습니다.
        HjBlog result = hjRepository.save(saveBlog);

        int resultValue = 0;

        // 저장 결과가 null이 아니면 성공적으로 저장되었음을 알리는 값을 설정한다.
        if (result != null) {
            resultValue = 1;
        }

        // 성공 여부를 나타내는 값을 반환합니다.
        return resultValue;
    }

    // List<JunBlog> - 이 메서드는 HjBlog 객체의 리스트를 반환
    // getAllBlogs() - 메서드 이름은 getAllBlogs이다. 이는 모든 블로그를 가져온다는 의미이다.
    public List<HjBlog> getAllBlogs() {
        return hjRepository.findAll();
    }

    // 글 상세조회

    public HjBlog getBlogById(Long blogid) {
        return hjRepository.findById(blogid).orElse(null);
    }

    // 글 수정

    public HjBlog updatePost(HjBlogDTO hjBlogDTO) {
        HjBlog hjBlog = hjRepository.findById(hjBlogDTO.getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid post Id:" + hjBlogDTO.getId()));
        hjBlog.setBlogTitle(hjBlogDTO.getBlogTitle());
        hjBlog.setBlogContent(hjBlogDTO.getBlogContent());
        return hjRepository.save(hjBlog);
    }

    // 글 삭제

    // 게시물 삭제

    @Transactional
    public void deleteBlog(Long id) {
        hjRepository.deleteById(id);
    }



}