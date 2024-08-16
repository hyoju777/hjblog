package com.ohgiraffers.familyblog.repository;

import com.ohgiraffers.familyblog.model.BlogPost;//BloogPost엔티티를 사용하기 위해 임포트한다.
import org.springframework.data.jpa.repository.JpaRepository; //Spring Data JPA의 JpaRepository 인터페이스르 인포트한다.

// 인터페이스 선언: BlogPostRepository는 JPaRepository를 확장하며
// BlogPost 엔티티와 그 기본 키 타입(Long)을 정의한다.
public interface BlogPostRepository extends JpaRepository<BlogPost, Long> { // JpaRepository를 상속받아 CRUD 및 기본 JPA 작업이 자동으로 제공된다. 별도의 메서드 구현 없이도 블로그 게시물 엔티티에 대한 데이터베이스 작업을 수행할 수 있다.
}