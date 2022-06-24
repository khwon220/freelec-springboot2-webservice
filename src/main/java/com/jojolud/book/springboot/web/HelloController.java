package com.jojolud.book.springboot.web;

import com.jojolud.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // json을 반환하는 컨트롤러
public class HelloController {
    @GetMapping("/hello") // HTTP Method인 Get의 요청을 받을 수 있는 API
    public String hello() { // /hello로 요청이 오면 문자열 hello를 반환
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
        /**
         * 1. @RequestParam
         *      - 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션
         *      - 외부에서 name (@RequestParam("name")) 이란 이름으로 넘긴 파라미터를 메소드 파라미터 name (String name)에 저장
         */
    }
}

