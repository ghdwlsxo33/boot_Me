package com.busanit501.boot501.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class RestSampleController {
    @GetMapping("/hiRest")
    public String[] hi() {
        log.info("hiTest");
        return new String[] {"오늘 점심은 항상 뭐먹지 고민하는중", "도시락","김치볶음밥"};
        //스프링 부트는 기본적으로 잭슨이라는 이름의 라이브러리 도구가 설치됨
        //역할 : 문자열 -> JSON 타입으로 자동 변환 해주는 도구
        //JSON : 컨버터
    }
}
