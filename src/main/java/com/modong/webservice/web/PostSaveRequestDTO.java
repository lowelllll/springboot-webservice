package com.modong.webservice.web;

import com.modong.webservice.domain.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostSaveRequestDTO {
    private String title;
    private String content;
    private String author;

    public Post toPost() {
        return Post.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
