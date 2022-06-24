package com.jojolud.book.springboot.web.dto;

import com.jojolud.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    /** Dto
     * Entity 클래스를 Request/Response 클래스로 절대 사용해서는 안 됨
     * Request/Response용 Dto는 View를 위한 클래스라 자주 변경이 필요함
     * Contorller에서 쓸 Dto는 꼭 Entity 클래스와 분리해서 사용
     */
    private String title;
    private String content;
    private String author;
    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
