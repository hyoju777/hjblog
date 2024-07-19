package com.ohgiraffers.post_st.model.dto;


//HjBlogDTO 클래스는 블로그 게시물의 데이터 전송 객체를 나타냄
public class HjBlogDTO {

    private Long id;//private는 접근 제어자를 나타내며, 이는 해당 변수가 클래스 내부에서만 접근 가능하다는 것을 의미합니다. 즉,
    // 외부 클래스에서는 이 변수에 접근할 수 없습니다.
    private String blogTitle;

    private String blogContent;//blogContent는 블로그 게시물의 내용을 저장하거나 처리하는데 사용되는 변수


    public HjBlogDTO() {
    }

    public HjBlogDTO(Long id, String blogTitle, String blogContent) {
        this.id = id;//this.id = id;는 매개변수로 전달된 id 값을 현재 객체의 id 변수에 할당하는 것을 의미합니다. 주로 생성자나 메서드에서 객체의 멤버 변수를 초기화하거나 설정할 때 사용됩니다. 예를 들어, 생성자에서 전달된 값을 객체의 멤버 변수에 저장하여 이후에 사용할 수 있도록 합니다.
        this.blogTitle = blogTitle;//this는 "바로 나 자신"을 가리키는 말이야. 프로그래밍에서 this를 사용하면 "이건 내 거야"라고 확실하게 알려주는 역할을 해.
        this.blogContent = blogContent;//내용물 저장처리
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    @Override
    public String toString() {
        return "HjBlogDTO{" +
                "id=" + id +
                ",blogTitle='" + blogTitle + '\'' +
                ",blogContent='" + blogContent + '\'' +
                '}';
    }
}
