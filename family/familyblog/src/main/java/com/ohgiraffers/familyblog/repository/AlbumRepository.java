package com.ohgiraffers.familyblog.repository;

import com.ohgiraffers.familyblog.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
}