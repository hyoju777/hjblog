package com.ohgiraffers.familyblog.repository; //패키지 선언: 이 클래스가 포함된 패키지를 지정한다.

import com.ohgiraffers.familyblog.model.Album; //Album 엔티티를 사용하기 위해 임포트한다.
import org.springframework.data.jpa.repository.JpaRepository;//Spring Data JPA의 jppaRepository 인터페이스를 인포트한다.

// 인터페이스 선언: AlbumRepository는 JpaRepository를 확장하며
// Album 엔티티와 그 기본 키 타입(Long)을 정의한다.
public interface AlbumRepository extends JpaRepository<Album, Long> {
    //JpaRepository를 상속받아 CRUD 및 기본 JPA 작업이 자동을 제공된다.
    //별도의 메서드 구현 없이도 앨범 엔티티에 대한 데이터베이스 작업을 수행할 수 있다.
}