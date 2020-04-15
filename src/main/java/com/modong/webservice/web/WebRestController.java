package com.modong.webservice.web;

import com.modong.webservice.domain.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController // @ResponseBody를 모든 메서드에 적용해줌.
@AllArgsConstructor
public class WebRestController {

    private PostRepository postRepository;

//    public WebRestController(PostRepository postRepository) {
//        this.postRepository = postRepository;
//    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @PostMapping("/posts")
    public void savePost(@RequestBody PostSaveRequestDTO request) {
        postRepository.save(request.toPost());
    }
}
