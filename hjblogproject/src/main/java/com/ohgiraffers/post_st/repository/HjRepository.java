package com.ohgiraffers.post_st.repository;

import com.ohgiraffers.post_st.model.entity.HjBlog;
import org.springframework.data.jpa.repository.HjRepository;

    //JpaRepository 인터페이스를 선언,HjBlog 엔티티를 관리하고,기본 키의 타입은 Integer
public interface HjRepository extends JpaRepository<HjBlog,Long>{

}
