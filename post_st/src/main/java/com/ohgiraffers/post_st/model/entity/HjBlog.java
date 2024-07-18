package com.ohgiraffers.post_st.model.entity;

// 엔티티는 컴퓨터 프로그램에서 중요한 물건이나 개념을 나타내는 단어
//API:Application Programming Interface"의 약자로, 응용 프로그램 개발 시에 다른 소프트웨어와 상호 작용할 수 있는 인터페이스를 제공하는 방법이나 규약을 의미합니다.

import jakarta.persistence.*;// Jakarta Persistence API에 포함된 모든 클래스들을 현재 파일에서 사용할 수 있도록 가져오겠다는 것을 의미합니다. 이는 주로 데이터베이스와 관련된 작업을 할 때 필요한 클래스들을 편리하게 사용할 수 있도록 해줍니다.

        import java.util.Date;

@Entity
@Table(name = "hj_blog")
public class Hjblog{

    @Id
    @Column(name = "blog_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "blog_title",unique = true,nullable = false)//이 옵션은 해당 컬럼의 값이 유일해야 함을 나타냅니다. 즉, 데이터베이스 테이블에 중복된 값이 없어야 합니다.
    private String blogTitle;//nullable = false: 이 옵션은 해당 컬럼의 값이 null이 될 수 없음을 //
    // 나타냅니다. 따라서 데이터베이스에 객체를 저장할 때 blogTitle 필드의 값은 반드시 설정되어 있어야 합니다.

    @Column(name = "blog_content",nullable = false,length = 5000)
    private String blogContent;

    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)//엔티티 클래스의 Date 또는 Calendar 타입 필드가 데이터베이스의 어떤 타입과 매핑되어야 하는지를 지정하는데 사용됩니다.
    private Date createDate;//@Temporal(TemporalType.TIMESTAMP): 이 부분은 날짜 및 시간 데이터의 형식을 지정합니다. TemporalType.TIMESTAMP은 날짜와 시간(타임스탬프) 정보를 포함하는 필드임을 나타내며, 이는 자바의 java.util.Date 형식과 매핑됩니다.

    public Hjblog(){
    }

    public HjBlog(Long id, String blogTitle, String blogContent,Date createDate){
        this.id = id;
        this.blogTitle = blogTitle;
        this.blogContent = blogContent;
        this.createDate = createDate;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle){
        this.blogTitle = blogTitle;
    }
}
public String getBlogContent() {
    return blogContent;
}

public void setBlogContent(String blogContent) {
    this.blogContent = blogContent;
}

public Date getCreateDate() {
    return createDate;
}

public void setCreateDate(Date createDate) {
    this.createDate = createDate;
}

@Override
public String toString() {
    return "HjBlog{" +
            "id=" + id +
            ", blogTitle='" + blogTitle + '\'' +
            ", blogContent='" + blogContent + '\'' +
            ", createDate=" + createDate +
            '}';
}
}