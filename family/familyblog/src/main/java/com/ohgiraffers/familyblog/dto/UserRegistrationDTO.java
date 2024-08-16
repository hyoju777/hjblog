package com.ohgiraffers.familyblog.dto;

public class UserRegistrationDTO {
    private String username;
    private String password;
    private String email;
    // getters and setters

    //기본 생성자
    public UserRegistrationDTO(){
    }

    // 매개변수가 있는 생성자
    public UserRegistrationDTO(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // username의 getter
    public String getUsername() {
        return username;
    }
    // username의 setter
    public void setUsername(String username) {
        this.username = username;
    }

    //password필드의 getter
    public String getPassword() {
        return password;
    }

    //password필드의 setter
    public void setPassword(String password) {
        this.password = password;
    }

    // email 필드의 getter
    public String getEmail() {
        return email;
    }
    // email 필드의 setter
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserRegistrationDTO{" +
                "username=" + username +
                ", password='" + password + '\'' +
                ", email='" + email + '\''+
                '}';
    }
}
