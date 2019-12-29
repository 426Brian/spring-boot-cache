package com.springbootcache.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;


@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

    /**
     * classpath:/templates/success.html
     *
     * @return
     */
    @RequestMapping("/demo")
    public String demo(Map<String, Object> map) {
        map.put("hello", "你好");
        return "success";
    }
}
