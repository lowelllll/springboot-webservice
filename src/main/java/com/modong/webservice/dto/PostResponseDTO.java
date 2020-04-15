package com.modong.webservice.dto;

import com.modong.webservice.domain.Post;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Getter
public class PostResponseDTO {
    private Long id;
    private String title;
    private String author;
    private String modifiedDate;

    public PostResponseDTO(Post post) {
        id = post.getId();
        title = post.getTitle();
        author = post.getAuthor();
        modifiedDate = toStringDateTime(post.getModifiedDate());
    }

    private String toStringDateTime(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("");
    }
}
