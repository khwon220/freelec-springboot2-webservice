package com.jojolud.book.springboot.config.auth.dto;

import com.jojolud.book.springboot.domain.user.User;
import lombok.Getter;

@Getter
public class SessionUser {
    // SessionUser에는 인증된 사용자 정보만 필요하므로 name, email, picture만 필드로 선언
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
