package com.ohgiraffers.familyblog.repository;

import com.ohgiraffers.familyblog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
