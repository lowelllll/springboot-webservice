package com.modong.webservice.domain;


import java.time.LocalDateTime;
import java.util.List;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @After
    public void cleanup() {
        postRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        // given
        postRepository.save(Post.builder()
                .title("테스트 게시글")
                .content("테스트 본문")
                .author("lowell@gmail.com")
                .build()
        );

        // when
        List<Post> posts = postRepository.findAll();

        //then
        Post post = posts.get(0);
        assertThat(post.getTitle(), is("테스트 게시글"));
        assertThat(post.getContent(), is("테스트 본문"));
    }

    @Test
    public void BaseTimeEntity_등록 () {
        // given
        LocalDateTime now = LocalDateTime.now();

        postRepository.save(Post.builder()
                .title("테스트 게시글")
                .content("본문")
                .author("lowell.gmail.com")
                .build()
        );

        // when
        List<Post> posts = postRepository.findAll();

        // then
        Post post = posts.get(0);
        assertTrue(post.getCreateDate().isAfter(now));
        assertTrue(post.getModifiedDate().isAfter(now));
    }
}