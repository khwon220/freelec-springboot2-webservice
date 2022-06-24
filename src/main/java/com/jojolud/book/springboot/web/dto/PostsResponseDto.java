package com.jojolud.book.springboot.web.dto;

import com.jojolud.book.springboot.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity) {
        /**
         * PostsResponseDto는 Entity의 필드 중 일부만 사용
         * 굳이 모든 필드를 가진 생성자가 필요하지 않으므로 Dto는 Entity를 받아 처리
         */
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
