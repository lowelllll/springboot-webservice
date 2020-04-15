package com.modong.webservice.dto;

import com.modong.webservice.domain.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostRequestDTO {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostRequestDTO(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Post toPost() {
        return Post.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

}
