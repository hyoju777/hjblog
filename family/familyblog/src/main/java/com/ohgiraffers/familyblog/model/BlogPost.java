package com.ohgiraffers.familyblog.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;

    // 기본 생성자
    public BlogPost() {
    }

    // 매개변수가 있는 생성자
    public BlogPost(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
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

    // content 필드의 getter
    public String getContent() {
        return content;
    }

    // content 필드의 setter
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "BlogPost{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
