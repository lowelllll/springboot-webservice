package com.modong.webservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @ResponseBody를 모든 메서드에 적용해줌.
public class WebRestController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
}
