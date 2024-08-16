package com.ohgiraffers.familyblog.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    // 기본 생성자
    public Album() {
    }

    // 매개변수가 있는 생성자
    public Album(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    // id 필드의 getter
    public Long getId() {
        return id;
    }

    // id 필드의 setter
    public void setId(Long id) {
        this.id = id;
    }

    // title 필드의 getter
    public String getTitle() {
        return title;
    }

    // title 필드의 setter
    public void setTitle(String title) {
        this.title = title;
    }

    // description 필드의 getter
    public String getDescription() {
        return description;
    }

    // description 필드의 setter
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}