package com.modong.webservice.web;

import com.modong.webservice.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class WebController {

    private PostService postService;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("posts", postService.findAllDesc());
        return "main"; //handlebars-spring-boot-starter 덕분에 컨트롤러에서 문자열을 반환할때 앞의 path와 뒤의 파일 확장자는 자동으로 지정
    }
}
