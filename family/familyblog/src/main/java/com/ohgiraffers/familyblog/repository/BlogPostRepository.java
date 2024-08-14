package com.ohgiraffers.familyblog.repository;

import com.ohgiraffers.familyblog.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
}