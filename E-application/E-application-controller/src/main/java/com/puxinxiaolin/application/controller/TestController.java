package com.puxinxiaolin.application.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/E")
@RestController
@Slf4j
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "666";
    }

}
