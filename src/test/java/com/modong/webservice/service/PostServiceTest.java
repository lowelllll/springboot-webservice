package com.modong.webservice.service;

import com.modong.webservice.domain.Post;
import com.modong.webservice.domain.PostRepository;
import com.modong.webservice.dto.PostRequestDTO;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostServiceTest {

    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;

    @After
    public void cleanUp() {
        postRepository.deleteAll();
    }

    @Test
    public void DTO데이터가_post테이블에_저장된다 () {
        PostRequestDTO request = PostRequestDTO.builder()
                .author("lowell@gmail.com")
                .title("제목")
                .content("내용")
                .build();

        postService.save(request);

        Post post = postRepository.findAll().get(0);
        assertThat(post.getAuthor()).isEqualTo(request.getAuthor());
        assertThat(post.getContent()).isEqualTo(request.getContent());
        assertThat(post.getTitle()).isEqualTo(request.getTitle());
    }
}