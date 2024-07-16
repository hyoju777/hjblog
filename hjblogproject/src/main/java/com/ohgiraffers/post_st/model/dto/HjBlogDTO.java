package com.ohgiraffers.post_st.model.dto;

public class HjBlogDTO {

    private Long id;

    private String blogTitle;

    private String blogContent;

    public HjblogDTO() {
    }

    public HjBlogDTO(Long id, String blogTitle, String blogContent){
        this.id = id;
        this.blogTitle = blogTitle;
        this.blogContent = blogContent;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getBlogTitle() { return blogTitle; }

    public void setBlogTitle(String blogTitle) { this.blogTitle = blogTitle; }

    public String getBlogContent() { return blogContent; }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }
    @Override
    pulic String toString(){
        return "JunBlogDTO{" +
                "id=" + id +
                ",blogTitle='" + blogTitle + '\'' +
                ",blogContent='" + blogContent + '\'' +
                '}';
     }
}
